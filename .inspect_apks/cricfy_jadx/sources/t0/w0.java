package t0;

import android.os.Build;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 extends WindowInsetsAnimation$Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.a f11816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f11817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList f11818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f11819d;

    public w0(a7.a aVar) {
        super(0);
        this.f11819d = new HashMap();
        this.f11816a = aVar;
    }

    public final z0 a(WindowInsetsAnimation windowInsetsAnimation) {
        z0 z0Var = (z0) this.f11819d.get(windowInsetsAnimation);
        if (z0Var == null) {
            z0Var = new z0(0, null, 0L);
            if (Build.VERSION.SDK_INT >= 30) {
                z0Var.f11831a = new x0(windowInsetsAnimation);
            }
            this.f11819d.put(windowInsetsAnimation, z0Var);
        }
        return z0Var;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        this.f11816a.f1(a(windowInsetsAnimation));
        this.f11819d.remove(windowInsetsAnimation);
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        this.f11816a.g1(a(windowInsetsAnimation));
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.f11818c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.f11818c = arrayList2;
            this.f11817b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimationH = v0.h(list.get(size));
            z0 z0VarA = a(windowInsetsAnimationH);
            z0VarA.f11831a.e(windowInsetsAnimationH.getFraction());
            this.f11818c.add(z0VarA);
        }
        return this.f11816a.h1(p1.h(null, windowInsets), this.f11817b).g();
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        nb.w wVarI1 = this.f11816a.i1(a(windowInsetsAnimation), new nb.w(bounds));
        wVarI1.getClass();
        v0.k();
        return v0.f(((l0.c) wVarI1.f9016w).e(), ((l0.c) wVarI1.f9017x).e());
    }
}
