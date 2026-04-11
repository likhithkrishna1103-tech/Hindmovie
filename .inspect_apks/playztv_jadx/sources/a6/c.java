package a6;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f591c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f589a = new byte[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f592d = 0;

    public final boolean a() {
        return this.f591c.f581b != 0;
    }

    public final b b() {
        byte[] bArr;
        if (this.f590b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (a()) {
            return this.f591c;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb2.append((char) c());
        }
        if (sb2.toString().startsWith("GIF")) {
            this.f591c.f = this.f590b.getShort();
            this.f591c.f585g = this.f590b.getShort();
            int iC = c();
            b bVar = this.f591c;
            bVar.f586h = (iC & 128) != 0;
            bVar.i = (int) Math.pow(2.0d, (iC & 7) + 1);
            this.f591c.f587j = c();
            b bVar2 = this.f591c;
            c();
            bVar2.getClass();
            if (this.f591c.f586h && !a()) {
                b bVar3 = this.f591c;
                bVar3.f580a = e(bVar3.i);
                b bVar4 = this.f591c;
                bVar4.f588k = bVar4.f580a[bVar4.f587j];
            }
        } else {
            this.f591c.f581b = 1;
        }
        if (!a()) {
            boolean z2 = false;
            while (!z2 && !a() && this.f591c.f582c <= Integer.MAX_VALUE) {
                int iC2 = c();
                if (iC2 == 33) {
                    int iC3 = c();
                    if (iC3 == 1) {
                        f();
                    } else if (iC3 == 249) {
                        this.f591c.f583d = new a();
                        c();
                        int iC4 = c();
                        a aVar = this.f591c.f583d;
                        int i10 = (iC4 & 28) >> 2;
                        aVar.f576g = i10;
                        if (i10 == 0) {
                            aVar.f576g = 1;
                        }
                        aVar.f = (iC4 & 1) != 0;
                        short s3 = this.f590b.getShort();
                        if (s3 < 2) {
                            s3 = 10;
                        }
                        a aVar2 = this.f591c.f583d;
                        aVar2.i = s3 * 10;
                        aVar2.f577h = c();
                        c();
                    } else if (iC3 == 254) {
                        f();
                    } else if (iC3 != 255) {
                        f();
                    } else {
                        d();
                        StringBuilder sb3 = new StringBuilder();
                        int i11 = 0;
                        while (true) {
                            bArr = this.f589a;
                            if (i11 >= 11) {
                                break;
                            }
                            sb3.append((char) bArr[i11]);
                            i11++;
                        }
                        if (sb3.toString().equals("NETSCAPE2.0")) {
                            do {
                                d();
                                if (bArr[0] == 1) {
                                    byte b10 = bArr[1];
                                    byte b11 = bArr[2];
                                    this.f591c.getClass();
                                }
                                if (this.f592d > 0) {
                                }
                            } while (!a());
                        } else {
                            f();
                        }
                    }
                } else if (iC2 == 44) {
                    b bVar5 = this.f591c;
                    if (bVar5.f583d == null) {
                        bVar5.f583d = new a();
                    }
                    bVar5.f583d.f571a = this.f590b.getShort();
                    this.f591c.f583d.f572b = this.f590b.getShort();
                    this.f591c.f583d.f573c = this.f590b.getShort();
                    this.f591c.f583d.f574d = this.f590b.getShort();
                    int iC5 = c();
                    boolean z10 = (iC5 & 128) != 0;
                    int iPow = (int) Math.pow(2.0d, (iC5 & 7) + 1);
                    a aVar3 = this.f591c.f583d;
                    aVar3.f575e = (iC5 & 64) != 0;
                    if (z10) {
                        aVar3.f579k = e(iPow);
                    } else {
                        aVar3.f579k = null;
                    }
                    this.f591c.f583d.f578j = this.f590b.position();
                    c();
                    f();
                    if (!a()) {
                        b bVar6 = this.f591c;
                        bVar6.f582c++;
                        bVar6.f584e.add(bVar6.f583d);
                    }
                } else if (iC2 != 59) {
                    this.f591c.f581b = 1;
                } else {
                    z2 = true;
                }
            }
            b bVar7 = this.f591c;
            if (bVar7.f582c < 0) {
                bVar7.f581b = 1;
            }
        }
        return this.f591c;
    }

    public final int c() {
        try {
            return this.f590b.get() & 255;
        } catch (Exception unused) {
            this.f591c.f581b = 1;
            return 0;
        }
    }

    public final void d() {
        int iC = c();
        this.f592d = iC;
        if (iC <= 0) {
            return;
        }
        int i = 0;
        int i10 = 0;
        while (true) {
            try {
                i10 = this.f592d;
                if (i >= i10) {
                    return;
                }
                i10 -= i;
                this.f590b.get(this.f589a, i, i10);
                i += i10;
            } catch (Exception e10) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    StringBuilder sbP = l4.a.p(i, i10, "Error Reading Block n: ", " count: ", " blockSize: ");
                    sbP.append(this.f592d);
                    Log.d("GifHeaderParser", sbP.toString(), e10);
                }
                this.f591c.f581b = 1;
                return;
            }
        }
    }

    public final int[] e(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.f590b.get(bArr);
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
        } catch (BufferUnderflowException e10) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e10);
            }
            this.f591c.f581b = 1;
            return iArr;
        }
    }

    public final void f() {
        int iC;
        do {
            iC = c();
            this.f590b.position(Math.min(this.f590b.position() + iC, this.f590b.limit()));
        } while (iC > 0);
    }
}
