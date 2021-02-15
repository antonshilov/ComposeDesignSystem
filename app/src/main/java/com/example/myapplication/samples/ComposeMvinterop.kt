package com.example.myapplication.samples

import android.widget.TextView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.runtime.rxjava2.subscribeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.badoo.mvicore.element.Reducer
import com.badoo.mvicore.feature.BaseFeature
import com.badoo.mvicore.feature.ReducerFeature
import com.example.myapplication.R
import io.reactivex.Observable

class CounterFeature : ReducerFeature<CounterFeature.Wish, CounterFeature.State, Nothing>(
    initialState = State(),
    reducer = ReducerImpl()
) {
    data class State(
        val counter: Int = 0
    )

    sealed class Wish {
        object IncreaseCounter : Wish()
    }

    class ReducerImpl : Reducer<State, Wish> {
        override fun invoke(state: State, wish: Wish): State = when (wish) {
            Wish.IncreaseCounter -> state.copy(
                counter = state.counter + 1
            )
        }
    }
}

@Composable
fun ComposeMviInterop() {
    val counterFeature = remember { CounterFeature() }
    val counterState = counterFeature.subscribeAsState(CounterFeature.State())
    val count = counterState.value.counter
    val context = LocalContext.current

    val textView = remember {
        TextView(context).apply {
            setOnClickListener {
                counterFeature.accept(CounterFeature.Wish.IncreaseCounter)
            }
            setTextColor(context.resources.getColor(R.color.white))
            contentDescription = "CounterAndroidView"
        }
    }

    Column {
        Text(
            text = "Compose Text Count = $count",
            modifier = Modifier.clickable(onClick = {
                counterFeature.accept(CounterFeature.Wish.IncreaseCounter)
            })
        )
        AndroidView(
            viewBlock = { textView },
            update = { view ->
                view.text = "Hello From AndroidViews World! Count = ${count}"
            }
        )
    }

}


@Preview
@Composable
fun PreviewMviCounter() {
    PreviewBackground {
        ComposeMviInterop()
    }
}

@Composable
fun <R : Any, T : R> BaseFeature<*, *, *, T, *>.subscribeAsState(initial: R): State<R> =
    Observable.wrap(this).subscribeAsState(initial)



