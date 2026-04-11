package v;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import v4.h0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f12526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12527d;

    public g() {
        int iHighestOneBit = Integer.bitCount(8) != 1 ? Integer.highestOneBit(7) << 1 : 8;
        this.f12527d = iHighestOneBit - 1;
        this.f12526c = new int[iHighestOneBit];
    }

    public void a(int i) {
        int[] iArr = this.f12526c;
        int i10 = this.f12525b;
        iArr[i10] = i;
        int i11 = this.f12527d & (i10 + 1);
        this.f12525b = i11;
        int i12 = this.f12524a;
        if (i11 == i12) {
            int length = iArr.length;
            int i13 = length - i12;
            int i14 = length << 1;
            if (i14 < 0) {
                throw new RuntimeException("Max array capacity exceeded");
            }
            int[] iArr2 = new int[i14];
            sd.i.g(0, i12, length, iArr, iArr2);
            sd.i.g(i13, 0, this.f12524a, this.f12526c, iArr2);
            this.f12526c = iArr2;
            this.f12524a = 0;
            this.f12525b = length;
            this.f12527d = i14 - 1;
        }
    }

    public void b(int i, int i10) {
        if (i < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i11 = this.f12527d;
        int i12 = i11 * 2;
        int[] iArr = this.f12526c;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.f12526c = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i12 >= iArr.length) {
            int[] iArr3 = new int[i11 * 4];
            this.f12526c = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = this.f12526c;
        iArr4[i12] = i;
        iArr4[i12 + 1] = i10;
        this.f12527d++;
    }

    public void c(RecyclerView recyclerView, boolean z10) {
        this.f12527d = 0;
        int[] iArr = this.f12526c;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        h0 h0Var = recyclerView.I;
        if (recyclerView.H == null || h0Var == null || !h0Var.i) {
            return;
        }
        if (z10) {
            if (!recyclerView.f1455z.y()) {
                h0Var.i(recyclerView.H.a(), this);
            }
        } else if (!recyclerView.O()) {
            h0Var.h(this.f12524a, this.f12525b, recyclerView.B0, this);
        }
        int i = this.f12527d;
        if (i > h0Var.f13254j) {
            h0Var.f13254j = i;
            h0Var.f13255k = z10;
            recyclerView.f1451x.n();
        }
    }
}
