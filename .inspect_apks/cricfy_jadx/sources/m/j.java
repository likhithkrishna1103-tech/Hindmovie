package m;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import t0.q0;
import t0.r0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f8015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r0 f8016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f8017e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f8014b = -1;
    public final i f = new i(this);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f8013a = new ArrayList();

    public final void a() {
        if (this.f8017e) {
            ArrayList arrayList = this.f8013a;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((q0) obj).b();
            }
            this.f8017e = false;
        }
    }

    public final void b() {
        View view;
        if (this.f8017e) {
            return;
        }
        ArrayList arrayList = this.f8013a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            q0 q0Var = (q0) obj;
            long j4 = this.f8014b;
            if (j4 >= 0) {
                q0Var.c(j4);
            }
            Interpolator interpolator = this.f8015c;
            if (interpolator != null && (view = (View) q0Var.f11795a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.f8016d != null) {
                q0Var.d(this.f);
            }
            View view2 = (View) q0Var.f11795a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.f8017e = true;
    }
}
