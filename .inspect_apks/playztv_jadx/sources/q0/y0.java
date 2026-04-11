package q0;

import android.os.Build;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y0 extends WindowInsetsAnimation$Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c3.e f10516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f10517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f10518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f10519d;

    public y0(c3.e eVar) {
        super(0);
        this.f10519d = new HashMap();
        this.f10516a = eVar;
    }

    public final b1 a(WindowInsetsAnimation windowInsetsAnimation) {
        b1 b1Var = (b1) this.f10519d.get(windowInsetsAnimation);
        if (b1Var == null) {
            b1Var = new b1(0, null, 0L);
            if (Build.VERSION.SDK_INT >= 30) {
                b1Var.f10421a = new z0(windowInsetsAnimation);
            }
            this.f10519d.put(windowInsetsAnimation, b1Var);
        }
        return b1Var;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        this.f10516a.f1(a(windowInsetsAnimation));
        this.f10519d.remove(windowInsetsAnimation);
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        this.f10516a.g1(a(windowInsetsAnimation));
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.f10518c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.f10518c = arrayList2;
            this.f10517b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimationK = a2.o.k(list.get(size));
            b1 b1VarA = a(windowInsetsAnimationK);
            b1VarA.f10421a.e(windowInsetsAnimationK.getFraction());
            this.f10518c.add(b1VarA);
        }
        return this.f10516a.h1(r1.h(null, windowInsets), this.f10517b).g();
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        pb.c cVarI1 = this.f10516a.i1(a(windowInsetsAnimation), new pb.c(bounds));
        cVarI1.getClass();
        a2.o.x();
        return a2.o.i(((i0.d) cVarI1.f10310v).e(), ((i0.d) cVarI1.f10311w).e());
    }
}
