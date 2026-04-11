package a2;

import android.view.View;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f442a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f446e;
    public Object f;

    public u0(int i) {
        this.f443b = i;
        byte[] bArr = new byte[131];
        this.f = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i, int i10) {
        if (this.f444c) {
            int i11 = i10 - i;
            byte[] bArr2 = (byte[]) this.f;
            int length = bArr2.length;
            int i12 = this.f446e;
            if (length < i12 + i11) {
                this.f = Arrays.copyOf(bArr2, (i12 + i11) * 2);
            }
            System.arraycopy(bArr, i, (byte[]) this.f, this.f446e, i11);
            this.f446e += i11;
        }
    }

    public void b() {
        this.f446e = this.f444c ? ((androidx.emoji2.text.h) this.f).i() : ((androidx.emoji2.text.h) this.f).m();
    }

    public void c(View view, int i) {
        if (this.f444c) {
            int iD = ((androidx.emoji2.text.h) this.f).d(view);
            androidx.emoji2.text.h hVar = (androidx.emoji2.text.h) this.f;
            this.f446e = (Integer.MIN_VALUE == hVar.f1174a ? 0 : hVar.n() - hVar.f1174a) + iD;
        } else {
            this.f446e = ((androidx.emoji2.text.h) this.f).g(view);
        }
        this.f443b = i;
    }

    public void d(View view, int i) {
        androidx.emoji2.text.h hVar = (androidx.emoji2.text.h) this.f;
        int iN = Integer.MIN_VALUE == hVar.f1174a ? 0 : hVar.n() - hVar.f1174a;
        if (iN >= 0) {
            c(view, i);
            return;
        }
        this.f443b = i;
        if (!this.f444c) {
            int iG = ((androidx.emoji2.text.h) this.f).g(view);
            int iM = iG - ((androidx.emoji2.text.h) this.f).m();
            this.f446e = iG;
            if (iM > 0) {
                int i10 = (((androidx.emoji2.text.h) this.f).i() - Math.min(0, (((androidx.emoji2.text.h) this.f).i() - iN) - ((androidx.emoji2.text.h) this.f).d(view))) - (((androidx.emoji2.text.h) this.f).e(view) + iG);
                if (i10 < 0) {
                    this.f446e -= Math.min(iM, -i10);
                    return;
                }
                return;
            }
            return;
        }
        int i11 = (((androidx.emoji2.text.h) this.f).i() - iN) - ((androidx.emoji2.text.h) this.f).d(view);
        this.f446e = ((androidx.emoji2.text.h) this.f).i() - i11;
        if (i11 > 0) {
            int iE = this.f446e - ((androidx.emoji2.text.h) this.f).e(view);
            int iM2 = ((androidx.emoji2.text.h) this.f).m();
            int iMin = iE - (Math.min(((androidx.emoji2.text.h) this.f).g(view) - iM2, 0) + iM2);
            if (iMin < 0) {
                this.f446e = Math.min(i11, -iMin) + this.f446e;
            }
        }
    }

    public boolean e(int i) {
        if (!this.f444c) {
            return false;
        }
        this.f446e -= i;
        this.f444c = false;
        this.f445d = true;
        return true;
    }

    public void f(int i) {
        this.f444c |= i > 0;
        this.f443b += i;
    }

    public void g() {
        switch (this.f442a) {
            case 1:
                this.f444c = false;
                this.f445d = false;
                break;
            default:
                this.f443b = -1;
                this.f446e = Integer.MIN_VALUE;
                this.f444c = false;
                this.f445d = false;
                break;
        }
    }

    public void h(int i) {
        s1.d.g(!this.f444c);
        boolean z2 = i == this.f443b;
        this.f444c = z2;
        if (z2) {
            this.f446e = 3;
            this.f445d = false;
        }
    }

    public String toString() {
        switch (this.f442a) {
            case 2:
                return "AnchorInfo{mPosition=" + this.f443b + ", mCoordinate=" + this.f446e + ", mLayoutFromEnd=" + this.f444c + ", mValid=" + this.f445d + '}';
            default:
                return super.toString();
        }
    }

    public u0(u1 u1Var) {
        this.f = u1Var;
    }

    public u0() {
        g();
    }
}
