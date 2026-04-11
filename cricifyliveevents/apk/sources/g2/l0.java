package g2;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4792a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f4796e;
    public Object f;

    public l0(int i) {
        this.f4793b = i;
        byte[] bArr = new byte[131];
        this.f = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i, int i10) {
        if (this.f4794c) {
            int i11 = i10 - i;
            byte[] bArr2 = (byte[]) this.f;
            int length = bArr2.length;
            int i12 = this.f4796e;
            if (length < i12 + i11) {
                this.f = Arrays.copyOf(bArr2, (i12 + i11) * 2);
            }
            System.arraycopy(bArr, i, (byte[]) this.f, this.f4796e, i11);
            this.f4796e += i11;
        }
    }

    public void b() {
        this.f4796e = this.f4794c ? ((androidx.emoji2.text.h) this.f).i() : ((androidx.emoji2.text.h) this.f).m();
    }

    public void c(View view, int i) {
        if (this.f4794c) {
            int iD = ((androidx.emoji2.text.h) this.f).d(view);
            androidx.emoji2.text.h hVar = (androidx.emoji2.text.h) this.f;
            this.f4796e = (Integer.MIN_VALUE == hVar.f856a ? 0 : hVar.n() - hVar.f856a) + iD;
        } else {
            this.f4796e = ((androidx.emoji2.text.h) this.f).g(view);
        }
        this.f4793b = i;
    }

    public void d(View view, int i) {
        androidx.emoji2.text.h hVar = (androidx.emoji2.text.h) this.f;
        int iN = Integer.MIN_VALUE == hVar.f856a ? 0 : hVar.n() - hVar.f856a;
        if (iN >= 0) {
            c(view, i);
            return;
        }
        this.f4793b = i;
        if (!this.f4794c) {
            int iG = ((androidx.emoji2.text.h) this.f).g(view);
            int iM = iG - ((androidx.emoji2.text.h) this.f).m();
            this.f4796e = iG;
            if (iM > 0) {
                int i10 = (((androidx.emoji2.text.h) this.f).i() - Math.min(0, (((androidx.emoji2.text.h) this.f).i() - iN) - ((androidx.emoji2.text.h) this.f).d(view))) - (((androidx.emoji2.text.h) this.f).e(view) + iG);
                if (i10 < 0) {
                    this.f4796e -= Math.min(iM, -i10);
                    return;
                }
                return;
            }
            return;
        }
        int i11 = (((androidx.emoji2.text.h) this.f).i() - iN) - ((androidx.emoji2.text.h) this.f).d(view);
        this.f4796e = ((androidx.emoji2.text.h) this.f).i() - i11;
        if (i11 > 0) {
            int iE = this.f4796e - ((androidx.emoji2.text.h) this.f).e(view);
            int iM2 = ((androidx.emoji2.text.h) this.f).m();
            int iMin = iE - (Math.min(((androidx.emoji2.text.h) this.f).g(view) - iM2, 0) + iM2);
            if (iMin < 0) {
                this.f4796e = Math.min(i11, -iMin) + this.f4796e;
            }
        }
    }

    public boolean e(int i) {
        if (!this.f4794c) {
            return false;
        }
        this.f4796e -= i;
        this.f4794c = false;
        this.f4795d = true;
        return true;
    }

    public void f(int i) {
        this.f4794c |= i > 0;
        this.f4793b += i;
    }

    public void g() {
        switch (this.f4792a) {
            case 1:
                this.f4794c = false;
                this.f4795d = false;
                break;
            default:
                this.f4793b = -1;
                this.f4796e = Integer.MIN_VALUE;
                this.f4794c = false;
                this.f4795d = false;
                break;
        }
    }

    public void h(int i) {
        y1.d.g(!this.f4794c);
        boolean z10 = i == this.f4793b;
        this.f4794c = z10;
        if (z10) {
            this.f4796e = 3;
            this.f4795d = false;
        }
    }

    public String toString() {
        switch (this.f4792a) {
            case 2:
                return "AnchorInfo{mPosition=" + this.f4793b + ", mCoordinate=" + this.f4796e + ", mLayoutFromEnd=" + this.f4794c + ", mValid=" + this.f4795d + '}';
            default:
                return super.toString();
        }
    }

    public l0(i1 i1Var) {
        this.f = i1Var;
    }

    public l0() {
        g();
    }
}
