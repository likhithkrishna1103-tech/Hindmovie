package z3;

import a3.k0;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import b2.q;
import java.util.ArrayList;
import java.util.List;
import ua.g0;
import ua.i0;
import ua.z0;
import x3.o;
import x3.p;
import y1.a0;
import y1.h;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements p {
    public static final byte[] C = {0, 7, 8, 15};
    public static final byte[] D = {0, 119, -120, -1};
    public static final byte[] E = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    public final f A;
    public Bitmap B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Paint f15198v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Paint f15199w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Canvas f15200x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b4.a f15201y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final a f15202z;

    public g(List list) {
        t tVar = new t((byte[]) list.get(0));
        int iD = tVar.D();
        int iD2 = tVar.D();
        Paint paint = new Paint();
        this.f15198v = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f15199w = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f15200x = new Canvas();
        this.f15201y = new b4.a(719, 575, 0, 719, 0, 575);
        this.f15202z = new a(0, new int[]{0, -1, -16777216, -8421505}, b(), c());
        this.A = new f(iD, iD2);
    }

    public static byte[] a(int i, int i10, k0 k0Var) {
        byte[] bArr = new byte[i];
        for (int i11 = 0; i11 < i; i11++) {
            bArr[i11] = (byte) k0Var.i(i10);
        }
        return bArr;
    }

    public static int[] b() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                iArr[i] = d(255, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                iArr[i] = d(255, (i & 1) != 0 ? 127 : 0, (i & 2) != 0 ? 127 : 0, (i & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    public static int[] c() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            if (i < 8) {
                iArr[i] = d(63, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) == 0 ? 0 : 255);
            } else {
                int i10 = i & 136;
                if (i10 == 0) {
                    iArr[i] = d(255, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i10 == 8) {
                    iArr[i] = d(127, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i10 == 128) {
                    iArr[i] = d(255, ((i & 1) != 0 ? 43 : 0) + 127 + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + 127 + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + 127 + ((i & 64) == 0 ? 0 : 85));
                } else if (i10 == 136) {
                    iArr[i] = d(255, ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + ((i & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int d(int i, int i10, int i11, int i12) {
        return (i << 24) | (i10 << 16) | (i11 << 8) | i12;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0203 A[LOOP:3: B:87:0x0156->B:119:0x0203, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ff A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(byte[] r21, int[] r22, int r23, int r24, int r25, android.graphics.Paint r26, android.graphics.Canvas r27) {
        /*
            Method dump skipped, instruction units count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.g.e(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    public static a f(k0 k0Var, int i) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = 8;
        int i16 = k0Var.i(8);
        k0Var.t(8);
        int i17 = 2;
        int i18 = i - 2;
        int i19 = 0;
        int[] iArr = {0, -1, -16777216, -8421505};
        int[] iArrB = b();
        int[] iArrC = c();
        while (i18 > 0) {
            int i20 = k0Var.i(i15);
            int i21 = k0Var.i(i15);
            int[] iArr2 = (i21 & 128) != 0 ? iArr : (i21 & 64) != 0 ? iArrB : iArrC;
            if ((i21 & 1) != 0) {
                i13 = k0Var.i(i15);
                i14 = k0Var.i(i15);
                i10 = k0Var.i(i15);
                i12 = k0Var.i(i15);
                i11 = i18 - 6;
            } else {
                int i22 = k0Var.i(6) << i17;
                int i23 = k0Var.i(4) << 4;
                i10 = k0Var.i(4) << 4;
                i11 = i18 - 4;
                i12 = k0Var.i(i17) << 6;
                i13 = i22;
                i14 = i23;
            }
            if (i13 == 0) {
                i14 = i19;
                i10 = i14;
                i12 = 255;
            }
            double d10 = i13;
            double d11 = i14 - 128;
            double d12 = i10 - 128;
            iArr2[i20] = d((byte) (255 - (i12 & 255)), a0.i((int) ((1.402d * d11) + d10), 0, 255), a0.i((int) ((d10 - (0.34414d * d12)) - (d11 * 0.71414d)), 0, 255), a0.i((int) ((d12 * 1.772d) + d10), 0, 255));
            i18 = i11;
            i19 = 0;
            i16 = i16;
            iArrC = iArrC;
            i15 = 8;
            i17 = 2;
        }
        return new a(i16, iArr, iArrB, iArrC);
    }

    public static b g(k0 k0Var) {
        byte[] bArr;
        int i = k0Var.i(16);
        k0Var.t(4);
        int i10 = k0Var.i(2);
        boolean zH = k0Var.h();
        k0Var.t(1);
        byte[] bArr2 = a0.f14553c;
        if (i10 != 1) {
            if (i10 == 0) {
                int i11 = k0Var.i(16);
                int i12 = k0Var.i(16);
                if (i11 > 0) {
                    bArr2 = new byte[i11];
                    k0Var.l(i11, bArr2);
                }
                if (i12 > 0) {
                    bArr = new byte[i12];
                    k0Var.l(i12, bArr);
                }
            }
            return new b(i, zH, bArr2, bArr);
        }
        k0Var.t(k0Var.i(8) * 16);
        bArr = bArr2;
        return new b(i, zH, bArr2, bArr);
    }

    @Override // x3.p
    public final void C(byte[] bArr, int i, int i10, o oVar, h hVar) {
        f fVar;
        boolean z10;
        x3.c cVar;
        char c9;
        char c10;
        char c11;
        int i11;
        ArrayList arrayList;
        int i12;
        b4.a aVar;
        f fVar2;
        d dVar;
        int i13;
        int i14;
        int i15;
        int i16;
        d dVar2;
        int i17;
        int i18;
        int i19;
        int i20;
        k0 k0Var = new k0(i + i10, bArr);
        k0Var.q(i);
        while (true) {
            int iB = k0Var.b();
            fVar = this.A;
            z10 = true;
            if (iB >= 48 && k0Var.i(8) == 15) {
                int i21 = k0Var.i(8);
                int i22 = k0Var.i(16);
                int i23 = k0Var.i(16);
                int iF = k0Var.f() + i23;
                if (i23 * 8 > k0Var.b()) {
                    y1.b.p("DvbParser", "Data field length exceeds limit");
                    k0Var.t(k0Var.b());
                } else {
                    switch (i21) {
                        case 16:
                            if (i22 == fVar.f15191a) {
                                q qVar = fVar.i;
                                k0Var.i(8);
                                int i24 = k0Var.i(4);
                                int i25 = k0Var.i(2);
                                k0Var.t(2);
                                int i26 = i23 - 2;
                                SparseArray sparseArray = new SparseArray();
                                while (i26 > 0) {
                                    int i27 = k0Var.i(8);
                                    k0Var.t(8);
                                    i26 -= 6;
                                    sparseArray.put(i27, new c(k0Var.i(16), k0Var.i(16)));
                                }
                                q qVar2 = new q();
                                qVar2.f1726v = i24;
                                qVar2.f1727w = i25;
                                qVar2.f1728x = sparseArray;
                                if (i25 != 0) {
                                    fVar.i = qVar2;
                                    fVar.f15193c.clear();
                                    fVar.f15194d.clear();
                                    fVar.f15195e.clear();
                                } else if (qVar != null && qVar.f1726v != i24) {
                                    fVar.i = qVar2;
                                }
                            }
                            break;
                        case 17:
                            q qVar3 = fVar.i;
                            SparseArray sparseArray2 = fVar.f15193c;
                            if (i22 == fVar.f15191a && qVar3 != null) {
                                int i28 = k0Var.i(8);
                                k0Var.t(4);
                                boolean zH = k0Var.h();
                                k0Var.t(3);
                                int i29 = k0Var.i(16);
                                int i30 = k0Var.i(16);
                                k0Var.i(3);
                                int i31 = k0Var.i(3);
                                k0Var.t(2);
                                int i32 = k0Var.i(8);
                                int i33 = k0Var.i(8);
                                int i34 = k0Var.i(4);
                                int i35 = k0Var.i(2);
                                k0Var.t(2);
                                int i36 = i23 - 10;
                                SparseArray sparseArray3 = new SparseArray();
                                while (i36 > 0) {
                                    int i37 = k0Var.i(16);
                                    int i38 = k0Var.i(2);
                                    k0Var.i(2);
                                    int i39 = k0Var.i(12);
                                    k0Var.t(4);
                                    int i40 = k0Var.i(12);
                                    int i41 = i36 - 6;
                                    if (i38 == 1 || i38 == 2) {
                                        k0Var.i(8);
                                        k0Var.i(8);
                                        i36 -= 8;
                                    } else {
                                        i36 = i41;
                                    }
                                    sparseArray3.put(i37, new e(i39, i40));
                                }
                                d dVar3 = new d(i28, zH, i29, i30, i31, i32, i33, i34, i35, sparseArray3);
                                if (qVar3.f1727w == 0 && (dVar2 = (d) sparseArray2.get(i28)) != null) {
                                    SparseArray sparseArray4 = dVar2.f15188j;
                                    for (int i42 = 0; i42 < sparseArray4.size(); i42++) {
                                        dVar3.f15188j.put(sparseArray4.keyAt(i42), (e) sparseArray4.valueAt(i42));
                                    }
                                }
                                sparseArray2.put(dVar3.f15181a, dVar3);
                            }
                            break;
                        case 18:
                            if (i22 == fVar.f15191a) {
                                a aVarF = f(k0Var, i23);
                                fVar.f15194d.put(aVarF.f15171a, aVarF);
                            } else if (i22 == fVar.f15192b) {
                                a aVarF2 = f(k0Var, i23);
                                fVar.f.put(aVarF2.f15171a, aVarF2);
                            }
                            break;
                        case 19:
                            if (i22 == fVar.f15191a) {
                                b bVarG = g(k0Var);
                                fVar.f15195e.put(bVarG.f15175a, bVarG);
                            } else if (i22 == fVar.f15192b) {
                                b bVarG2 = g(k0Var);
                                fVar.f15196g.put(bVarG2.f15175a, bVarG2);
                            }
                            break;
                        case 20:
                            if (i22 == fVar.f15191a) {
                                k0Var.t(4);
                                boolean zH2 = k0Var.h();
                                k0Var.t(3);
                                int i43 = k0Var.i(16);
                                int i44 = k0Var.i(16);
                                if (zH2) {
                                    int i45 = k0Var.i(16);
                                    i17 = k0Var.i(16);
                                    i20 = k0Var.i(16);
                                    i18 = k0Var.i(16);
                                    i19 = i45;
                                } else {
                                    i17 = i43;
                                    i18 = i44;
                                    i19 = 0;
                                    i20 = 0;
                                }
                                fVar.f15197h = new b4.a(i43, i44, i19, i17, i20, i18);
                            }
                            break;
                    }
                    k0Var.u(iF - k0Var.f());
                }
            }
        }
        q qVar4 = fVar.i;
        if (qVar4 == null) {
            g0 g0Var = i0.f12341w;
            cVar = new x3.c(-9223372036854775807L, -9223372036854775807L, z0.f12413z);
        } else {
            b4.a aVar2 = fVar.f15197h;
            if (aVar2 == null) {
                aVar2 = this.f15201y;
            }
            Bitmap bitmap = this.B;
            Canvas canvas = this.f15200x;
            if (bitmap == null || aVar2.f1752a + 1 != bitmap.getWidth() || aVar2.f1753b + 1 != this.B.getHeight()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(aVar2.f1752a + 1, aVar2.f1753b + 1, Bitmap.Config.ARGB_8888);
                this.B = bitmapCreateBitmap;
                canvas.setBitmap(bitmapCreateBitmap);
            }
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray5 = (SparseArray) qVar4.f1728x;
            int i46 = 0;
            while (i46 < sparseArray5.size()) {
                canvas.save();
                c cVar2 = (c) sparseArray5.valueAt(i46);
                d dVar4 = (d) fVar.f15193c.get(sparseArray5.keyAt(i46));
                int i47 = cVar2.f15179a + aVar2.f1754c;
                int i48 = cVar2.f15180b + aVar2.f1756e;
                int i49 = dVar4.f15183c;
                int i50 = dVar4.f;
                int i51 = dVar4.f15184d;
                boolean z11 = z10;
                int i52 = i47 + i49;
                int i53 = i48 + i51;
                SparseArray sparseArray6 = sparseArray5;
                canvas.clipRect(i47, i48, Math.min(i52, aVar2.f1755d), Math.min(i53, aVar2.f));
                a aVar3 = (a) fVar.f15194d.get(i50);
                if (aVar3 == null && (aVar3 = (a) fVar.f.get(i50)) == null) {
                    aVar3 = this.f15202z;
                }
                SparseArray sparseArray7 = dVar4.f15188j;
                int i54 = i46;
                int i55 = 0;
                while (i55 < sparseArray7.size()) {
                    int iKeyAt = sparseArray7.keyAt(i55);
                    SparseArray sparseArray8 = sparseArray7;
                    e eVar = (e) sparseArray7.valueAt(i55);
                    int i56 = i48;
                    b bVar = (b) fVar.f15195e.get(iKeyAt);
                    if (bVar == null) {
                        bVar = (b) fVar.f15196g.get(iKeyAt);
                    }
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        Paint paint = bVar2.f15176b ? null : this.f15198v;
                        int i57 = i47;
                        int i58 = dVar4.f15185e;
                        fVar2 = fVar;
                        int i59 = i57 + eVar.f15189a;
                        int i60 = i56 + eVar.f15190b;
                        int i61 = i51;
                        Paint paint2 = paint;
                        aVar = aVar2;
                        i14 = i49;
                        i13 = i57;
                        arrayList = arrayList2;
                        i12 = i56;
                        d dVar5 = dVar4;
                        int[] iArr = i58 == 3 ? aVar3.f15174d : i58 == 2 ? aVar3.f15173c : aVar3.f15172b;
                        dVar = dVar5;
                        i15 = i55;
                        i16 = i61;
                        e(bVar2.f15177c, iArr, i58, i59, i60, paint2, canvas);
                        e(bVar2.f15178d, iArr, i58, i59, i60 + 1, paint2, canvas);
                    } else {
                        arrayList = arrayList2;
                        i12 = i56;
                        aVar = aVar2;
                        fVar2 = fVar;
                        dVar = dVar4;
                        i13 = i47;
                        i14 = i49;
                        i15 = i55;
                        i16 = i51;
                    }
                    i55 = i15 + 1;
                    i49 = i14;
                    i48 = i12;
                    dVar4 = dVar;
                    i47 = i13;
                    arrayList2 = arrayList;
                    sparseArray7 = sparseArray8;
                    aVar2 = aVar;
                    fVar = fVar2;
                    i51 = i16;
                }
                b4.a aVar4 = aVar2;
                ArrayList arrayList3 = arrayList2;
                f fVar3 = fVar;
                int i62 = i48;
                d dVar6 = dVar4;
                int i63 = i47;
                int i64 = i49;
                int i65 = i51;
                if (dVar6.f15182b) {
                    int i66 = dVar6.f15185e;
                    if (i66 == 3) {
                        i11 = aVar3.f15174d[dVar6.f15186g];
                        c11 = 2;
                    } else {
                        c11 = 2;
                        i11 = i66 == 2 ? aVar3.f15173c[dVar6.f15187h] : aVar3.f15172b[dVar6.i];
                    }
                    Paint paint3 = this.f15199w;
                    paint3.setColor(i11);
                    c9 = c11;
                    c10 = 3;
                    canvas.drawRect(i63, i62, i52, i53, paint3);
                } else {
                    c9 = 2;
                    c10 = 3;
                }
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.B, i63, i62, i64, i65);
                float f = aVar4.f1752a;
                float f10 = aVar4.f1753b;
                arrayList3.add(new x1.b(null, null, null, bitmapCreateBitmap2, i62 / f10, 0, 0, i63 / f, 0, Integer.MIN_VALUE, -3.4028235E38f, i64 / f, i65 / f10, false, -16777216, Integer.MIN_VALUE, 0.0f, 0));
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.restore();
                i46 = i54 + 1;
                z10 = z11;
                aVar2 = aVar4;
                arrayList2 = arrayList3;
                fVar = fVar3;
                sparseArray5 = sparseArray6;
            }
            cVar = new x3.c(-9223372036854775807L, -9223372036854775807L, arrayList2);
        }
        hVar.accept(cVar);
    }

    @Override // x3.p
    public final int D() {
        return 2;
    }

    @Override // x3.p
    public final /* synthetic */ x3.g r(byte[] bArr, int i, int i10) {
        return l0.e.a(this, bArr, i10);
    }

    @Override // x3.p
    public final void reset() {
        f fVar = this.A;
        fVar.f15193c.clear();
        fVar.f15194d.clear();
        fVar.f15195e.clear();
        fVar.f.clear();
        fVar.f15196g.clear();
        fVar.f15197h = null;
        fVar.i = null;
    }
}
