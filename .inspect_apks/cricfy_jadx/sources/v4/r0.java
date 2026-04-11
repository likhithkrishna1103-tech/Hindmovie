package v4;

import android.util.Log;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Interpolator f13344e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13345g;

    public final void a(RecyclerView recyclerView) {
        int i = this.f13343d;
        if (i >= 0) {
            this.f13343d = -1;
            recyclerView.Q(i);
            this.f = false;
            return;
        }
        if (!this.f) {
            this.f13345g = 0;
            return;
        }
        Interpolator interpolator = this.f13344e;
        if (interpolator != null && this.f13342c < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        int i10 = this.f13342c;
        if (i10 < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
        recyclerView.f1454y0.c(this.f13340a, this.f13341b, i10, interpolator);
        int i11 = this.f13345g + 1;
        this.f13345g = i11;
        if (i11 > 10) {
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
        }
        this.f = false;
    }
}
