package v6;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f13475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f13476c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f13474a = new byte[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13477d = 0;

    public final boolean a() {
        return this.f13476c.f13466b != 0;
    }

    public final b b() {
        byte[] bArr;
        if (this.f13475b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (a()) {
            return this.f13476c;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) c());
        }
        if (sb.toString().startsWith("GIF")) {
            this.f13476c.f = this.f13475b.getShort();
            this.f13476c.f13470g = this.f13475b.getShort();
            int iC = c();
            b bVar = this.f13476c;
            bVar.f13471h = (iC & 128) != 0;
            bVar.i = (int) Math.pow(2.0d, (iC & 7) + 1);
            this.f13476c.f13472j = c();
            b bVar2 = this.f13476c;
            c();
            bVar2.getClass();
            if (this.f13476c.f13471h && !a()) {
                b bVar3 = this.f13476c;
                bVar3.f13465a = e(bVar3.i);
                b bVar4 = this.f13476c;
                bVar4.f13473k = bVar4.f13465a[bVar4.f13472j];
            }
        } else {
            this.f13476c.f13466b = 1;
        }
        if (!a()) {
            boolean z10 = false;
            while (!z10 && !a() && this.f13476c.f13467c <= Integer.MAX_VALUE) {
                int iC2 = c();
                if (iC2 == 33) {
                    int iC3 = c();
                    if (iC3 == 1) {
                        f();
                    } else if (iC3 == 249) {
                        this.f13476c.f13468d = new a();
                        c();
                        int iC4 = c();
                        a aVar = this.f13476c.f13468d;
                        int i10 = (iC4 & 28) >> 2;
                        aVar.f13461g = i10;
                        if (i10 == 0) {
                            aVar.f13461g = 1;
                        }
                        aVar.f = (iC4 & 1) != 0;
                        short s10 = this.f13475b.getShort();
                        if (s10 < 2) {
                            s10 = 10;
                        }
                        a aVar2 = this.f13476c.f13468d;
                        aVar2.i = s10 * 10;
                        aVar2.f13462h = c();
                        c();
                    } else if (iC3 == 254) {
                        f();
                    } else if (iC3 != 255) {
                        f();
                    } else {
                        d();
                        StringBuilder sb2 = new StringBuilder();
                        int i11 = 0;
                        while (true) {
                            bArr = this.f13474a;
                            if (i11 >= 11) {
                                break;
                            }
                            sb2.append((char) bArr[i11]);
                            i11++;
                        }
                        if (sb2.toString().equals("NETSCAPE2.0")) {
                            do {
                                d();
                                if (bArr[0] == 1) {
                                    byte b8 = bArr[1];
                                    byte b10 = bArr[2];
                                    this.f13476c.getClass();
                                }
                                if (this.f13477d > 0) {
                                }
                            } while (!a());
                        } else {
                            f();
                        }
                    }
                } else if (iC2 == 44) {
                    b bVar5 = this.f13476c;
                    if (bVar5.f13468d == null) {
                        bVar5.f13468d = new a();
                    }
                    bVar5.f13468d.f13456a = this.f13475b.getShort();
                    this.f13476c.f13468d.f13457b = this.f13475b.getShort();
                    this.f13476c.f13468d.f13458c = this.f13475b.getShort();
                    this.f13476c.f13468d.f13459d = this.f13475b.getShort();
                    int iC5 = c();
                    boolean z11 = (iC5 & 128) != 0;
                    int iPow = (int) Math.pow(2.0d, (iC5 & 7) + 1);
                    a aVar3 = this.f13476c.f13468d;
                    aVar3.f13460e = (iC5 & 64) != 0;
                    if (z11) {
                        aVar3.f13464k = e(iPow);
                    } else {
                        aVar3.f13464k = null;
                    }
                    this.f13476c.f13468d.f13463j = this.f13475b.position();
                    c();
                    f();
                    if (!a()) {
                        b bVar6 = this.f13476c;
                        bVar6.f13467c++;
                        bVar6.f13469e.add(bVar6.f13468d);
                    }
                } else if (iC2 != 59) {
                    this.f13476c.f13466b = 1;
                } else {
                    z10 = true;
                }
            }
            b bVar7 = this.f13476c;
            if (bVar7.f13467c < 0) {
                bVar7.f13466b = 1;
            }
        }
        return this.f13476c;
    }

    public final int c() {
        try {
            return this.f13475b.get() & 255;
        } catch (Exception unused) {
            this.f13476c.f13466b = 1;
            return 0;
        }
    }

    public final void d() {
        int iC = c();
        this.f13477d = iC;
        if (iC <= 0) {
            return;
        }
        int i = 0;
        int i10 = 0;
        while (true) {
            try {
                i10 = this.f13477d;
                if (i >= i10) {
                    return;
                }
                i10 -= i;
                this.f13475b.get(this.f13474a, i, i10);
                i += i10;
            } catch (Exception e9) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    StringBuilder sbR = q4.a.r(i, i10, "Error Reading Block n: ", " count: ", " blockSize: ");
                    sbR.append(this.f13477d);
                    Log.d("GifHeaderParser", sbR.toString(), e9);
                }
                this.f13476c.f13466b = 1;
                return;
            }
        }
    }

    public final int[] e(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.f13475b.get(bArr);
            iArr = new int[256];
            int i10 = 0;
            int i11 = 0;
            while (i10 < i) {
                int i12 = bArr[i11] & 255;
                int i13 = i11 + 2;
                int i14 = bArr[i11 + 1] & 255;
                i11 += 3;
                int i15 = i10 + 1;
                iArr[i10] = (i14 << 8) | (i12 << 16) | (-16777216) | (bArr[i13] & 255);
                i10 = i15;
            }
            return iArr;
        } catch (BufferUnderflowException e9) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e9);
            }
            this.f13476c.f13466b = 1;
            return iArr;
        }
    }

    public final void f() {
        int iC;
        do {
            iC = c();
            this.f13475b.position(Math.min(this.f13475b.position() + iC, this.f13475b.limit()));
        } while (iC > 0);
    }
}
