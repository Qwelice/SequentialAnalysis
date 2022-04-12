package calculation

import calculation.args.InitArgs
import calculation.utils.comb
import kotlin.math.max
import kotlin.math.pow

class SequentialAnalysis(val args: InitArgs) {
    val S = HashMap<Int, SData>()

    val P: Double
        get() = (args.r - args.a) / (args.b - args.a)

    val Cn: Double
        get() = (1 + args.r).pow(-args.N) * F(args.N, args.startS, P)

    init {
        S[0] = SData(args.startS, true)
    }

    fun addS(n: Int, isIncreased: Boolean){
        val ro = if (isIncreased) {
            args.b
        } else {
            args.a
        }
        if (S.containsKey(n - 1)) {
            S[n] = SData(S[n - 1]!!.value * (1 + ro), isIncreased)
        }
    }

    fun F(n: Int, x: Double, p: Double): Double {
        var result = 0.0
        for (k in 0..n) {
            result += max(x * (1 + args.b).pow(k) * (1 + args.a).pow(n - k) - args.T, 0.0) * comb(n, k) * p.pow(k) * (1 - p).pow(n - k)
        }
        return result
    }

    fun getB(n: Int):Double{
        var result = args.startB
        for (i in 1..n){
            result *= (1 + args.r)
        }
        return result
    }

    fun gammaN(n: Int): Double {
        var result = 0.0
        if (S.containsKey(n - 1)) {
            result = (1 + args.r).pow(n - args.N) *
                    ( F(args.N - n, S[n - 1]!!.value * (1 + args.b), P) -
                    F(args.N - n,S[n - 1]!!.value * (1 + args.a), P) ) / ( S[n - 1]!!.value * (args.b - args.a) )
        }
        return result
    }

    fun betaN(n: Int): Double {
        var result = 0.0
        if (S.containsKey(n - 1)) {
            result = F(args.N - n + 1, S[n - 1]!!.value, P) / getB(args.N) -
                    (1 + args.r).pow(n - args.N) *
                    ( F(args.N - n, S[n - 1]!!.value * (1 + args.b), P) -
                            F(args.N - n,S[n - 1]!!.value * (1 + args.a), P) ) / ( getB(n - 1) * (args.b - args.a))

        }
        return result
    }
}