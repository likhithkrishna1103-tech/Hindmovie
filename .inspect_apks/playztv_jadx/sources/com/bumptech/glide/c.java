package com.bumptech.glide;

import a2.f0;
import aa.h1;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.widget.EdgeEffect;
import com.playz.tv.app.IGlideModule;
import g4.s0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import p1.l0;
import p1.m0;
import w1.u;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile u5.d f2766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile u5.c f2767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static u f2768c;

    public static v1.m b(e2.m mVar, String str, e2.j jVar, int i) {
        Map map = Collections.EMPTY_MAP;
        Uri uriO = s1.b.o(str, jVar.f4339c);
        long j5 = jVar.f4337a;
        long j8 = jVar.f4338b;
        String strA = mVar.a();
        if (strA == null) {
            strA = s1.b.o(((e2.b) mVar.f4344v.get(0)).f4295a, jVar.f4339c).toString();
        }
        String str2 = strA;
        s1.d.i(uriO, "The uri must be set.");
        return new v1.m(uriO, 0L, 1, null, h1.A, j5, j8, str2, i);
    }

    public static void c(long j5, hf.f fVar, int i, ArrayList arrayList, int i10, int i11, ArrayList arrayList2) {
        int i12;
        int i13;
        ArrayList arrayList3;
        long j8;
        int i14;
        int i15 = i;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i10 >= i11) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i16 = i10; i16 < i11; i16++) {
            if (((hf.i) arrayList4.get(i16)).a() < i15) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        hf.i iVar = (hf.i) arrayList.get(i10);
        hf.i iVar2 = (hf.i) arrayList4.get(i11 - 1);
        if (i15 == iVar.a()) {
            int iIntValue = ((Number) arrayList5.get(i10)).intValue();
            int i17 = i10 + 1;
            hf.i iVar3 = (hf.i) arrayList4.get(i17);
            i12 = i17;
            i13 = iIntValue;
            iVar = iVar3;
        } else {
            i12 = i10;
            i13 = -1;
        }
        if (iVar.d(i15) == iVar2.d(i15)) {
            int iMin = Math.min(iVar.a(), iVar2.a());
            int i18 = 0;
            for (int i19 = i15; i19 < iMin && iVar.d(i19) == iVar2.d(i19); i19++) {
                i18++;
            }
            long j10 = 4;
            long j11 = (fVar.f6113v / j10) + j5 + ((long) 2) + ((long) i18) + 1;
            fVar.l0(-i18);
            fVar.l0(i13);
            int i20 = i15 + i18;
            while (i15 < i20) {
                fVar.l0(iVar.d(i15) & 255);
                i15++;
            }
            if (i12 + 1 == i11) {
                if (i20 != ((hf.i) arrayList4.get(i12)).a()) {
                    throw new IllegalStateException("Check failed.");
                }
                fVar.l0(((Number) arrayList5.get(i12)).intValue());
                return;
            } else {
                hf.f fVar2 = new hf.f();
                fVar.l0(((int) ((fVar2.f6113v / j10) + j11)) * (-1));
                c(j11, fVar2, i20, arrayList4, i12, i11, arrayList5);
                fVar.i0(fVar2);
                return;
            }
        }
        int i21 = 1;
        for (int i22 = i12 + 1; i22 < i11; i22++) {
            if (((hf.i) arrayList4.get(i22 - 1)).d(i15) != ((hf.i) arrayList4.get(i22)).d(i15)) {
                i21++;
            }
        }
        long j12 = 4;
        long j13 = (fVar.f6113v / j12) + j5 + ((long) 2) + ((long) (i21 * 2));
        fVar.l0(i21);
        fVar.l0(i13);
        for (int i23 = i12; i23 < i11; i23++) {
            int iD = ((hf.i) arrayList4.get(i23)).d(i15);
            if (i23 == i12 || iD != ((hf.i) arrayList4.get(i23 - 1)).d(i15)) {
                fVar.l0(iD & 255);
            }
        }
        hf.f fVar3 = new hf.f();
        int i24 = i12;
        while (i24 < i11) {
            byte bD = ((hf.i) arrayList4.get(i24)).d(i15);
            int i25 = i24 + 1;
            int i26 = i25;
            while (true) {
                if (i26 >= i11) {
                    i26 = i11;
                    break;
                } else if (bD != ((hf.i) arrayList4.get(i26)).d(i15)) {
                    break;
                } else {
                    i26++;
                }
            }
            if (i25 == i26 && i15 + 1 == ((hf.i) arrayList4.get(i24)).a()) {
                fVar.l0(((Number) arrayList5.get(i24)).intValue());
                arrayList3 = arrayList5;
                j8 = j13;
                i14 = i26;
            } else {
                fVar.l0(((int) ((fVar3.f6113v / j12) + j13)) * (-1));
                arrayList3 = arrayList5;
                j8 = j13;
                i14 = i26;
                c(j8, fVar3, i15 + 1, arrayList, i24, i14, arrayList3);
                arrayList4 = arrayList;
            }
            j13 = j8;
            i24 = i14;
            arrayList5 = arrayList3;
        }
        fVar.i0(fVar3);
    }

    public static void f(v1.h hVar) {
        if (hVar != null) {
            try {
                hVar.close();
            } catch (IOException unused) {
            }
        }
    }

    public static na.b g(String str, String str2) {
        wb.a aVar = new wb.a(str, str2);
        na.a aVarA = na.b.a(wb.a.class);
        aVarA.f8875c = 1;
        aVarA.f8878g = new b2.e(aVar);
        return aVarA.b();
    }

    public static na.b j(String str, s0 s0Var) {
        na.a aVarA = na.b.a(wb.a.class);
        aVarA.f8875c = 1;
        aVarA.a(na.j.a(Context.class));
        aVarA.f8878g = new b2.b(str, 23, s0Var);
        return aVarA.b();
    }

    public static float k(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return u0.c.b(edgeEffect);
        }
        return 0.0f;
    }

    public static int l(String str) {
        if (str == null) {
            return -1;
        }
        String strP = m0.p(str);
        strP.getClass();
        switch (strP) {
        }
        return -1;
    }

    public static int m(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
            return 15;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
            return 14;
        }
        if (lastPathSegment.endsWith(".avi")) {
            return 16;
        }
        if (lastPathSegment.endsWith(".png")) {
            return 17;
        }
        if (lastPathSegment.endsWith(".webp")) {
            return 18;
        }
        if (lastPathSegment.endsWith(".bmp") || lastPathSegment.endsWith(".dib")) {
            return 19;
        }
        if (lastPathSegment.endsWith(".heic") || lastPathSegment.endsWith(".heif")) {
            return 20;
        }
        return lastPathSegment.endsWith(".avif") ? 21 : -1;
    }

    public static u5.c o(Context context) {
        u5.c cVar;
        Context applicationContext = context.getApplicationContext();
        u5.c cVar2 = f2767b;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (u5.c.class) {
            try {
                cVar = f2767b;
                if (cVar == null) {
                    cVar = new u5.c(0, new f0(28, applicationContext));
                    f2767b = cVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x014a, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static hf.n p(hf.i... r13) {
        /*
            Method dump skipped, instruction units count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.c.p(hf.i[]):hf.n");
    }

    public static float q(EdgeEffect edgeEffect, float f, float f4) {
        if (Build.VERSION.SDK_INT >= 31) {
            return u0.c.c(edgeEffect, f, f4);
        }
        u0.b.a(edgeEffect, f, f4);
        return f;
    }

    public static f1.b r(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j5;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
        int i = byteBufferDuplicate.getShort() & 65535;
        if (i > 100) {
            throw new IOException("Cannot read metadata.");
        }
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
        int i10 = 0;
        while (true) {
            if (i10 >= i) {
                j5 = -1;
                break;
            }
            int i11 = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            j5 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            if (1835365473 == i11) {
                break;
            }
            i10++;
        }
        if (j5 != -1) {
            byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) (j5 - ((long) byteBufferDuplicate.position()))));
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
            long j8 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            for (int i12 = 0; i12 < j8; i12++) {
                int i13 = byteBufferDuplicate.getInt();
                long j10 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
                byteBufferDuplicate.getInt();
                if (1164798569 == i13 || 1701669481 == i13) {
                    byteBufferDuplicate.position((int) (j10 + j5));
                    f1.b bVar = new f1.b();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                    bVar.f4694x = byteBufferDuplicate;
                    bVar.f4691u = iPosition;
                    int i14 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    bVar.f4692v = i14;
                    bVar.f4693w = ((ByteBuffer) bVar.f4694x).getShort(i14);
                    return bVar;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static z3.g t(z3.g gVar, String[] strArr, Map map) {
        int i = 0;
        if (gVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (z3.g) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                z3.g gVar2 = new z3.g();
                int length = strArr.length;
                while (i < length) {
                    gVar2.a((z3.g) map.get(strArr[i]));
                    i++;
                }
                return gVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                gVar.a((z3.g) map.get(strArr[0]));
                return gVar;
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    gVar.a((z3.g) map.get(strArr[i]));
                    i++;
                }
            }
        }
        return gVar;
    }

    public static int x(int i) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        for (int i10 = 0; i10 < 6; i10++) {
            int i11 = iArr[i10];
            int i12 = i11 - 1;
            if (i11 == 0) {
                throw null;
            }
            if (i12 == i) {
                return i11;
            }
        }
        return 1;
    }

    public boolean d() {
        return false;
    }

    public abstract List e(String str, List list);

    public l0 h(f3.a aVar) {
        ByteBuffer byteBuffer = aVar.data;
        byteBuffer.getClass();
        s1.d.b(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        return i(aVar, byteBuffer);
    }

    public abstract l0 i(f3.a aVar, ByteBuffer byteBuffer);

    public boolean n() {
        return !(this instanceof IGlideModule);
    }

    public abstract void v();

    public abstract void w();

    public void a() {
    }

    public void u() {
    }

    public void s(Context context, b bVar, i iVar) {
    }
}
