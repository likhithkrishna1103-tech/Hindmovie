package q4;

import android.util.Log;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Interpolator f10916e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10917g;

    public final void a(RecyclerView recyclerView) {
        int i = this.f10915d;
        if (i >= 0) {
            this.f10915d = -1;
            recyclerView.Q(i);
            this.f = false;
            return;
        }
        if (!this.f) {
            this.f10917g = 0;
            return;
        }
        Interpolator interpolator = this.f10916e;
        if (interpolator != null && this.f10914c < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        int i10 = this.f10914c;
        if (i10 < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
        recyclerView.f1669x0.c(this.f10912a, this.f10913b, i10, interpolator);
        int i11 = this.f10917g + 1;
        this.f10917g = i11;
        if (i11 > 10) {
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
        }
        this.f = false;
    }
}
