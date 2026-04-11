package l;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import q0.t0;
import q0.u0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f7801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u0 f7802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7803e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7800b = -1;
    public final i f = new i(this);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f7799a = new ArrayList();

    public final void a() {
        if (this.f7803e) {
            ArrayList arrayList = this.f7799a;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((t0) obj).b();
            }
            this.f7803e = false;
        }
    }

    public final void b() {
        View view;
        if (this.f7803e) {
            return;
        }
        ArrayList arrayList = this.f7799a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            t0 t0Var = (t0) obj;
            long j5 = this.f7800b;
            if (j5 >= 0) {
                t0Var.c(j5);
            }
            Interpolator interpolator = this.f7801c;
            if (interpolator != null && (view = (View) t0Var.f10499a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.f7802d != null) {
                t0Var.d(this.f);
            }
            View view2 = (View) t0Var.f10499a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.f7803e = true;
    }
}
