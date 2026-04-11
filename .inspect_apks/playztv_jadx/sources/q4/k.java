package q4;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f10859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10862d;

    public k() {
        int iHighestOneBit = Integer.bitCount(8) != 1 ? Integer.highestOneBit(7) << 1 : 8;
        this.f10862d = iHighestOneBit - 1;
        this.f10859a = new int[iHighestOneBit];
    }

    public void a(int i) {
        int[] iArr = this.f10859a;
        int i10 = this.f10861c;
        iArr[i10] = i;
        int i11 = this.f10862d & (i10 + 1);
        this.f10861c = i11;
        int i12 = this.f10860b;
        if (i11 == i12) {
            int length = iArr.length;
            int i13 = length - i12;
            int i14 = length << 1;
            if (i14 < 0) {
                throw new RuntimeException("Max array capacity exceeded");
            }
            int[] iArr2 = new int[i14];
            od.h.S(0, i12, length, iArr, iArr2);
            od.h.S(i13, 0, this.f10860b, this.f10859a, iArr2);
            this.f10859a = iArr2;
            this.f10860b = 0;
            this.f10861c = length;
            this.f10862d = i14 - 1;
        }
    }

    public void b(int i, int i10) {
        if (i < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i11 = this.f10862d;
        int i12 = i11 * 2;
        int[] iArr = this.f10859a;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.f10859a = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i12 >= iArr.length) {
            int[] iArr3 = new int[i11 * 4];
            this.f10859a = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = this.f10859a;
        iArr4[i12] = i;
        iArr4[i12 + 1] = i10;
        this.f10862d++;
    }

    public void c(RecyclerView recyclerView, boolean z2) {
        this.f10862d = 0;
        int[] iArr = this.f10859a;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        h0 h0Var = recyclerView.H;
        if (recyclerView.G == null || h0Var == null || !h0Var.i) {
            return;
        }
        if (z2) {
            if (!recyclerView.f1670y.m()) {
                h0Var.i(recyclerView.G.a(), this);
            }
        } else if (!recyclerView.O()) {
            h0Var.h(this.f10860b, this.f10861c, recyclerView.A0, this);
        }
        int i = this.f10862d;
        if (i > h0Var.f10824j) {
            h0Var.f10824j = i;
            h0Var.f10825k = z2;
            recyclerView.f1666w.m();
        }
    }
}
