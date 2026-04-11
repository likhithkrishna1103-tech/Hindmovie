package v4;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13182e;
    public int[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f13183g;

    public a1(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f13183g = staggeredGridLayoutManager;
        a();
    }

    public final void a() {
        this.f13178a = -1;
        this.f13179b = Integer.MIN_VALUE;
        this.f13180c = false;
        this.f13181d = false;
        this.f13182e = false;
        int[] iArr = this.f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }
}
