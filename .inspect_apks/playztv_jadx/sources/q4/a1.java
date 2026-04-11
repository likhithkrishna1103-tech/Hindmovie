package q4;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10745e;
    public int[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f10746g;

    public a1(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f10746g = staggeredGridLayoutManager;
        a();
    }

    public final void a() {
        this.f10741a = -1;
        this.f10742b = Integer.MIN_VALUE;
        this.f10743c = false;
        this.f10744d = false;
        this.f10745e = false;
        int[] iArr = this.f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }
}
