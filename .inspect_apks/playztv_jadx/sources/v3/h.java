package v3;

import aa.c1;
import aa.h0;
import aa.j0;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import e6.j;
import java.util.ArrayList;
import java.util.List;
import s1.b0;
import s1.t;
import s1.u;
import t3.l;
import t3.m;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements m {
    public static final byte[] B = {0, 7, 8, 15};
    public static final byte[] C = {0, 119, -120, -1};
    public static final byte[] D = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    public Bitmap A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Paint f13259u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Paint f13260v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Canvas f13261w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b f13262x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a f13263y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final g f13264z;

    public h(List list) {
        u uVar = new u((byte[]) list.get(0));
        int iD = uVar.D();
        int iD2 = uVar.D();
        Paint paint = new Paint();
        this.f13259u = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f13260v = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f13261w = new Canvas();
        this.f13262x = new b(719, 575, 0, 719, 0, 575);
        this.f13263y = new a(0, new int[]{0, -1, -16777216, -8421505}, b(), c());
        this.f13264z = new g(iD, iD2);
    }

    public static byte[] a(int i, int i10, t tVar) {
        byte[] bArr = new byte[i];
        for (int i11 = 0; i11 < i; i11++) {
            bArr[i11] = (byte) tVar.i(i10);
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
                int i10 = i & 1;
                int i11 = ModuleDescriptor.MODULE_VERSION;
                int i12 = i10 != 0 ? 127 : 0;
                int i13 = (i & 2) != 0 ? 127 : 0;
                if ((i & 4) == 0) {
                    i11 = 0;
                }
                iArr[i] = d(255, i12, i13, i11);
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
                    iArr[i] = d(ModuleDescriptor.MODULE_VERSION, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i10 == 128) {
                    iArr[i] = d(255, ((i & 1) != 0 ? 43 : 0) + ModuleDescriptor.MODULE_VERSION + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ModuleDescriptor.MODULE_VERSION + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + ModuleDescriptor.MODULE_VERSION + ((i & 64) == 0 ? 0 : 85));
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
        throw new UnsupportedOperationException("Method not decompiled: v3.h.e(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    public static a f(t tVar, int i) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = 8;
        int i16 = tVar.i(8);
        tVar.t(8);
        int i17 = 2;
        int i18 = i - 2;
        int i19 = 0;
        int[] iArr = {0, -1, -16777216, -8421505};
        int[] iArrB = b();
        int[] iArrC = c();
        while (i18 > 0) {
            int i20 = tVar.i(i15);
            int i21 = tVar.i(i15);
            int[] iArr2 = (i21 & 128) != 0 ? iArr : (i21 & 64) != 0 ? iArrB : iArrC;
            if ((i21 & 1) != 0) {
                i13 = tVar.i(i15);
                i14 = tVar.i(i15);
                i10 = tVar.i(i15);
                i12 = tVar.i(i15);
                i11 = i18 - 6;
            } else {
                int i22 = tVar.i(6) << i17;
                int i23 = tVar.i(4) << 4;
                i10 = tVar.i(4) << 4;
                i11 = i18 - 4;
                i12 = tVar.i(i17) << 6;
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
            iArr2[i20] = d((byte) (255 - (i12 & 255)), b0.i((int) ((1.402d * d11) + d10), 0, 255), b0.i((int) ((d10 - (0.34414d * d12)) - (d11 * 0.71414d)), 0, 255), b0.i((int) ((d12 * 1.772d) + d10), 0, 255));
            i18 = i11;
            i19 = 0;
            i16 = i16;
            iArrC = iArrC;
            i15 = 8;
            i17 = 2;
        }
        return new a(i16, iArr, iArrB, iArrC);
    }

    public static c g(t tVar) {
        byte[] bArr;
        int i = tVar.i(16);
        tVar.t(4);
        int i10 = tVar.i(2);
        boolean zH = tVar.h();
        tVar.t(1);
        byte[] bArr2 = b0.f11649c;
        if (i10 != 1) {
            if (i10 == 0) {
                int i11 = tVar.i(16);
                int i12 = tVar.i(16);
                if (i11 > 0) {
                    bArr2 = new byte[i11];
                    tVar.l(i11, bArr2);
                }
                if (i12 > 0) {
                    bArr = new byte[i12];
                    tVar.l(i12, bArr);
                }
            }
            return new c(i, zH, bArr2, bArr);
        }
        tVar.t(tVar.i(8) * 16);
        bArr = bArr2;
        return new c(i, zH, bArr2, bArr);
    }

    @Override // t3.m
    public final /* synthetic */ t3.d h(byte[] bArr, int i, int i10) {
        return j.a(this, bArr, i10);
    }

    @Override // t3.m
    public final int m() {
        return 2;
    }

    @Override // t3.m
    public final void n(byte[] bArr, int i, int i10, l lVar, s1.h hVar) {
        g gVar;
        boolean z2;
        t3.a aVar;
        char c9;
        char c10;
        char c11;
        int i11;
        ArrayList arrayList;
        int i12;
        b bVar;
        g gVar2;
        e eVar;
        int i13;
        int i14;
        int i15;
        int i16;
        e eVar2;
        int i17;
        int i18;
        int i19;
        int i20;
        t tVar = new t(i + i10, bArr);
        tVar.q(i);
        while (true) {
            int iB = tVar.b();
            gVar = this.f13264z;
            z2 = true;
            if (iB >= 48 && tVar.i(8) == 15) {
                int i21 = tVar.i(8);
                int i22 = tVar.i(16);
                int i23 = tVar.i(16);
                int iF = tVar.f() + i23;
                if (i23 * 8 > tVar.b()) {
                    s1.b.p("DvbParser", "Data field length exceeds limit");
                    tVar.t(tVar.b());
                } else {
                    switch (i21) {
                        case 16:
                            if (i22 == gVar.f13252a) {
                                a0.g gVar3 = gVar.i;
                                tVar.i(8);
                                int i24 = tVar.i(4);
                                int i25 = tVar.i(2);
                                tVar.t(2);
                                int i26 = i23 - 2;
                                SparseArray sparseArray = new SparseArray();
                                while (i26 > 0) {
                                    int i27 = tVar.i(8);
                                    tVar.t(8);
                                    i26 -= 6;
                                    sparseArray.put(i27, new d(tVar.i(16), tVar.i(16)));
                                }
                                a0.g gVar4 = new a0.g();
                                gVar4.f59u = i24;
                                gVar4.f60v = i25;
                                gVar4.f61w = sparseArray;
                                if (i25 != 0) {
                                    gVar.i = gVar4;
                                    gVar.f13254c.clear();
                                    gVar.f13255d.clear();
                                    gVar.f13256e.clear();
                                } else if (gVar3 != null && gVar3.f59u != i24) {
                                    gVar.i = gVar4;
                                }
                            }
                            break;
                        case 17:
                            a0.g gVar5 = gVar.i;
                            SparseArray sparseArray2 = gVar.f13254c;
                            if (i22 == gVar.f13252a && gVar5 != null) {
                                int i28 = tVar.i(8);
                                tVar.t(4);
                                boolean zH = tVar.h();
                                tVar.t(3);
                                int i29 = tVar.i(16);
                                int i30 = tVar.i(16);
                                tVar.i(3);
                                int i31 = tVar.i(3);
                                tVar.t(2);
                                int i32 = tVar.i(8);
                                int i33 = tVar.i(8);
                                int i34 = tVar.i(4);
                                int i35 = tVar.i(2);
                                tVar.t(2);
                                int i36 = i23 - 10;
                                SparseArray sparseArray3 = new SparseArray();
                                while (i36 > 0) {
                                    int i37 = tVar.i(16);
                                    int i38 = tVar.i(2);
                                    tVar.i(2);
                                    int i39 = tVar.i(12);
                                    tVar.t(4);
                                    int i40 = tVar.i(12);
                                    int i41 = i36 - 6;
                                    if (i38 == 1 || i38 == 2) {
                                        tVar.i(8);
                                        tVar.i(8);
                                        i36 -= 8;
                                    } else {
                                        i36 = i41;
                                    }
                                    sparseArray3.put(i37, new f(i39, i40));
                                }
                                e eVar3 = new e(i28, zH, i29, i30, i31, i32, i33, i34, i35, sparseArray3);
                                if (gVar5.f60v == 0 && (eVar2 = (e) sparseArray2.get(i28)) != null) {
                                    SparseArray sparseArray4 = eVar2.f13249j;
                                    for (int i42 = 0; i42 < sparseArray4.size(); i42++) {
                                        eVar3.f13249j.put(sparseArray4.keyAt(i42), (f) sparseArray4.valueAt(i42));
                                    }
                                }
                                sparseArray2.put(eVar3.f13242a, eVar3);
                            }
                            break;
                        case 18:
                            if (i22 == gVar.f13252a) {
                                a aVarF = f(tVar, i23);
                                gVar.f13255d.put(aVarF.f13227a, aVarF);
                            } else if (i22 == gVar.f13253b) {
                                a aVarF2 = f(tVar, i23);
                                gVar.f.put(aVarF2.f13227a, aVarF2);
                            }
                            break;
                        case 19:
                            if (i22 == gVar.f13252a) {
                                c cVarG = g(tVar);
                                gVar.f13256e.put(cVarG.f13236a, cVarG);
                            } else if (i22 == gVar.f13253b) {
                                c cVarG2 = g(tVar);
                                gVar.f13257g.put(cVarG2.f13236a, cVarG2);
                            }
                            break;
                        case 20:
                            if (i22 == gVar.f13252a) {
                                tVar.t(4);
                                boolean zH2 = tVar.h();
                                tVar.t(3);
                                int i43 = tVar.i(16);
                                int i44 = tVar.i(16);
                                if (zH2) {
                                    int i45 = tVar.i(16);
                                    i17 = tVar.i(16);
                                    i20 = tVar.i(16);
                                    i18 = tVar.i(16);
                                    i19 = i45;
                                } else {
                                    i17 = i43;
                                    i18 = i44;
                                    i19 = 0;
                                    i20 = 0;
                                }
                                gVar.f13258h = new b(i43, i44, i19, i17, i20, i18);
                            }
                            break;
                    }
                    tVar.u(iF - tVar.f());
                }
            }
        }
        a0.g gVar6 = gVar.i;
        if (gVar6 == null) {
            h0 h0Var = j0.f690v;
            aVar = new t3.a(-9223372036854775807L, -9223372036854775807L, c1.f650y);
        } else {
            b bVar2 = gVar.f13258h;
            if (bVar2 == null) {
                bVar2 = this.f13262x;
            }
            Bitmap bitmap = this.A;
            Canvas canvas = this.f13261w;
            if (bitmap == null || bVar2.f13231a + 1 != bitmap.getWidth() || bVar2.f13232b + 1 != this.A.getHeight()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bVar2.f13231a + 1, bVar2.f13232b + 1, Bitmap.Config.ARGB_8888);
                this.A = bitmapCreateBitmap;
                canvas.setBitmap(bitmapCreateBitmap);
            }
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray5 = (SparseArray) gVar6.f61w;
            int i46 = 0;
            while (i46 < sparseArray5.size()) {
                canvas.save();
                d dVar = (d) sparseArray5.valueAt(i46);
                e eVar4 = (e) gVar.f13254c.get(sparseArray5.keyAt(i46));
                int i47 = dVar.f13240a + bVar2.f13233c;
                int i48 = dVar.f13241b + bVar2.f13235e;
                int i49 = eVar4.f13244c;
                int i50 = eVar4.f;
                int i51 = eVar4.f13245d;
                boolean z10 = z2;
                int i52 = i47 + i49;
                int i53 = i48 + i51;
                SparseArray sparseArray6 = sparseArray5;
                canvas.clipRect(i47, i48, Math.min(i52, bVar2.f13234d), Math.min(i53, bVar2.f));
                a aVar2 = (a) gVar.f13255d.get(i50);
                if (aVar2 == null && (aVar2 = (a) gVar.f.get(i50)) == null) {
                    aVar2 = this.f13263y;
                }
                SparseArray sparseArray7 = eVar4.f13249j;
                int i54 = i46;
                int i55 = 0;
                while (i55 < sparseArray7.size()) {
                    int iKeyAt = sparseArray7.keyAt(i55);
                    SparseArray sparseArray8 = sparseArray7;
                    f fVar = (f) sparseArray7.valueAt(i55);
                    int i56 = i48;
                    c cVar = (c) gVar.f13256e.get(iKeyAt);
                    if (cVar == null) {
                        cVar = (c) gVar.f13257g.get(iKeyAt);
                    }
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        Paint paint = cVar2.f13237b ? null : this.f13259u;
                        int i57 = i47;
                        int i58 = eVar4.f13246e;
                        gVar2 = gVar;
                        int i59 = i57 + fVar.f13250a;
                        int i60 = i56 + fVar.f13251b;
                        int i61 = i51;
                        Paint paint2 = paint;
                        bVar = bVar2;
                        i14 = i49;
                        i13 = i57;
                        arrayList = arrayList2;
                        i12 = i56;
                        e eVar5 = eVar4;
                        int[] iArr = i58 == 3 ? aVar2.f13230d : i58 == 2 ? aVar2.f13229c : aVar2.f13228b;
                        eVar = eVar5;
                        i15 = i55;
                        i16 = i61;
                        e(cVar2.f13238c, iArr, i58, i59, i60, paint2, canvas);
                        e(cVar2.f13239d, iArr, i58, i59, i60 + 1, paint2, canvas);
                    } else {
                        arrayList = arrayList2;
                        i12 = i56;
                        bVar = bVar2;
                        gVar2 = gVar;
                        eVar = eVar4;
                        i13 = i47;
                        i14 = i49;
                        i15 = i55;
                        i16 = i51;
                    }
                    i55 = i15 + 1;
                    i49 = i14;
                    i48 = i12;
                    eVar4 = eVar;
                    i47 = i13;
                    arrayList2 = arrayList;
                    sparseArray7 = sparseArray8;
                    bVar2 = bVar;
                    gVar = gVar2;
                    i51 = i16;
                }
                b bVar3 = bVar2;
                ArrayList arrayList3 = arrayList2;
                g gVar7 = gVar;
                int i62 = i48;
                e eVar6 = eVar4;
                int i63 = i47;
                int i64 = i49;
                int i65 = i51;
                if (eVar6.f13243b) {
                    int i66 = eVar6.f13246e;
                    if (i66 == 3) {
                        i11 = aVar2.f13230d[eVar6.f13247g];
                        c11 = 2;
                    } else {
                        c11 = 2;
                        i11 = i66 == 2 ? aVar2.f13229c[eVar6.f13248h] : aVar2.f13228b[eVar6.i];
                    }
                    Paint paint3 = this.f13260v;
                    paint3.setColor(i11);
                    c9 = c11;
                    c10 = 3;
                    canvas.drawRect(i63, i62, i52, i53, paint3);
                } else {
                    c9 = 2;
                    c10 = 3;
                }
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.A, i63, i62, i64, i65);
                float f = bVar3.f13231a;
                float f4 = bVar3.f13232b;
                arrayList3.add(new r1.b(null, null, null, bitmapCreateBitmap2, i62 / f4, 0, 0, i63 / f, 0, Integer.MIN_VALUE, -3.4028235E38f, i64 / f, i65 / f4, false, -16777216, Integer.MIN_VALUE, 0.0f, 0));
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.restore();
                i46 = i54 + 1;
                z2 = z10;
                bVar2 = bVar3;
                arrayList2 = arrayList3;
                gVar = gVar7;
                sparseArray5 = sparseArray6;
            }
            aVar = new t3.a(-9223372036854775807L, -9223372036854775807L, arrayList2);
        }
        hVar.accept(aVar);
    }

    @Override // t3.m
    public final void reset() {
        g gVar = this.f13264z;
        gVar.f13254c.clear();
        gVar.f13255d.clear();
        gVar.f13256e.clear();
        gVar.f.clear();
        gVar.f13257g.clear();
        gVar.f13258h = null;
        gVar.i = null;
    }
}
