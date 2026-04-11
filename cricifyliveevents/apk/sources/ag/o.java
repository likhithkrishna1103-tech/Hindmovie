package ag;

import android.graphics.Bitmap;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import g7.a0;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import z6.b0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements l7.b, p2.v, u0.o {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f453v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f454w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f455x;

    public /* synthetic */ o(char c9, int i) {
        this.f453v = i;
    }

    public void a(long j4) {
        int i = this.f454w;
        long[] jArr = (long[]) this.f455x;
        if (i == jArr.length) {
            this.f455x = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = (long[]) this.f455x;
        int i10 = this.f454w;
        this.f454w = i10 + 1;
        jArr2[i10] = j4;
    }

    public void b(long[] jArr) {
        int length = this.f454w + jArr.length;
        long[] jArr2 = (long[]) this.f455x;
        if (length > jArr2.length) {
            this.f455x = Arrays.copyOf(jArr2, Math.max(jArr2.length * 2, length));
        }
        System.arraycopy(jArr, 0, (long[]) this.f455x, this.f454w, jArr.length);
        this.f454w = length;
    }

    @Override // u0.o
    public boolean c(View view) {
        ((BottomSheetBehavior) this.f455x).G(this.f454w);
        return true;
    }

    @Override // p2.v
    public MediaCodecInfo d(int i) {
        if (((MediaCodecInfo[]) this.f455x) == null) {
            this.f455x = new MediaCodecList(this.f454w).getCodecInfos();
        }
        return ((MediaCodecInfo[]) this.f455x)[i];
    }

    @Override // l7.b
    public b0 e(b0 b0Var, x6.h hVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) b0Var.get()).compress((Bitmap.CompressFormat) this.f455x, this.f454w, byteArrayOutputStream);
        b0Var.e();
        return new a0(byteArrayOutputStream.toByteArray());
    }

    public void f(int i, int i10) {
        int i11 = i10 + i;
        char[] cArr = (char[]) this.f455x;
        if (cArr.length <= i11) {
            int i12 = i * 2;
            if (i11 < i12) {
                i11 = i12;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i11);
            ge.i.d(cArrCopyOf, "copyOf(...)");
            this.f455x = cArrCopyOf;
        }
    }

    public long g(int i) {
        if (i >= 0 && i < this.f454w) {
            return ((long[]) this.f455x)[i];
        }
        StringBuilder sbM = l0.e.m(i, "Invalid index ", ", size is ");
        sbM.append(this.f454w);
        throw new IndexOutOfBoundsException(sbM.toString());
    }

    public boolean h() {
        return ((s6.a) this.f455x) != null;
    }

    public void i(int i, c cVar) {
        while (true) {
            int i10 = i >> 1;
            if (i10 == 0) {
                break;
            }
            c cVar2 = ((c[]) this.f455x)[i10];
            ge.i.b(cVar2);
            if (ge.i.g(0L, cVar.f425g - cVar2.f425g) <= 0) {
                break;
            }
            cVar2.f = i;
            ((c[]) this.f455x)[i] = cVar2;
            i = i10;
        }
        ((c[]) this.f455x)[i] = cVar;
        cVar.f = i;
    }

    @Override // p2.v
    public boolean j(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    @Override // p2.v
    public int k() {
        if (((MediaCodecInfo[]) this.f455x) == null) {
            this.f455x = new MediaCodecList(this.f454w).getCodecInfos();
        }
        return ((MediaCodecInfo[]) this.f455x).length;
    }

    public long l(a3.l lVar) {
        y1.t tVar = (y1.t) this.f455x;
        int i = 0;
        lVar.v(tVar.f14609a, 0, 1, false);
        int i10 = tVar.f14609a[0] & 255;
        if (i10 == 0) {
            return Long.MIN_VALUE;
        }
        int i11 = 128;
        int i12 = 0;
        while ((i10 & i11) == 0) {
            i11 >>= 1;
            i12++;
        }
        int i13 = i10 & (~i11);
        lVar.v(tVar.f14609a, 1, i12, false);
        while (i < i12) {
            i++;
            i13 = (tVar.f14609a[i] & 255) + (i13 << 8);
        }
        this.f454w = i12 + 1 + this.f454w;
        return i13;
    }

    public void m() {
        ff.b bVar = ff.b.f4576c;
        char[] cArr = (char[]) this.f455x;
        bVar.getClass();
        ge.i.e(cArr, "array");
        synchronized (bVar) {
            int i = bVar.f729a;
            if (cArr.length + i < ff.a.f4575a) {
                bVar.f729a = i + cArr.length;
                ((sd.h) bVar.f730b).addLast(cArr);
            }
        }
    }

    public void n(c cVar) {
        c cVar2;
        int i = cVar.f;
        if (i == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i10 = this.f454w;
        c cVar3 = ((c[]) this.f455x)[i10];
        ge.i.b(cVar3);
        cVar.f = -1;
        ((c[]) this.f455x)[i10] = null;
        this.f454w = i10 - 1;
        if (cVar == cVar3) {
            return;
        }
        int iG = ge.i.g(0L, cVar3.f425g - cVar.f425g);
        if (iG == 0) {
            ((c[]) this.f455x)[i] = cVar3;
            cVar3.f = i;
            return;
        }
        if (iG >= 0) {
            i(i, cVar3);
            return;
        }
        while (true) {
            int i11 = i << 1;
            int i12 = i11 + 1;
            int i13 = this.f454w;
            if (i12 > i13) {
                if (i11 > i13) {
                    break;
                }
                cVar2 = ((c[]) this.f455x)[i11];
                ge.i.b(cVar2);
            } else {
                cVar2 = ((c[]) this.f455x)[i11];
                ge.i.b(cVar2);
                c cVar4 = ((c[]) this.f455x)[i12];
                ge.i.b(cVar4);
                if (ge.i.g(0L, cVar4.f425g - cVar2.f425g) >= 0) {
                    cVar2 = cVar4;
                }
            }
            if (ge.i.g(0L, cVar2.f425g - cVar3.f425g) <= 0) {
                break;
            }
            int i14 = cVar2.f;
            cVar2.f = i;
            ((c[]) this.f455x)[i] = cVar2;
            i = i14;
        }
        ((c[]) this.f455x)[i] = cVar3;
        cVar3.f = i;
    }

    public void o(String str) {
        ge.i.e(str, "text");
        int length = str.length();
        if (length == 0) {
            return;
        }
        f(this.f454w, length);
        str.getChars(0, str.length(), (char[]) this.f455x, this.f454w);
        this.f454w += length;
    }

    @Override // p2.v
    public boolean r(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    public String toString() {
        switch (this.f453v) {
            case 1:
                return new String((char[]) this.f455x, 0, this.f454w);
            default:
                return super.toString();
        }
    }

    @Override // p2.v
    public boolean u() {
        return true;
    }

    public /* synthetic */ o(int i, int i10, Object obj) {
        this.f453v = i10;
        this.f455x = obj;
        this.f454w = i;
    }

    public o(l8.b bVar, int i) {
        this.f453v = 3;
        o8.u.g(bVar);
        this.f455x = bVar;
        this.f454w = i;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(int i, byte b8) {
        this(32);
        this.f453v = i;
        switch (i) {
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                this.f455x = new y1.t(8);
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                this.f454w = 255;
                this.f455x = null;
                break;
            case 9:
            case 10:
            default:
                this.f455x = Bitmap.CompressFormat.JPEG;
                this.f454w = 100;
                break;
            case 11:
                break;
        }
    }

    public o(int i, String str) {
        this.f453v = 9;
        this.f454w = i;
        this.f455x = str;
    }

    public o(int i) {
        this.f453v = 11;
        this.f455x = new long[i];
    }

    public o(boolean z10, boolean z11, boolean z12) {
        this.f453v = 4;
        this.f454w = (z10 || z11 || z12) ? 1 : 0;
    }
}
