package com.bumptech.glide;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import f9.v1;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import ka.v;
import pe.x;
import w4.b0;
import w4.t;
import w4.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static final a5.i A(c5.a aVar, String str, boolean z10) throws Exception {
        c5.c cVarC0 = aVar.c0("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int iC = c.c(cVarC0, "seqno");
            int iC2 = c.c(cVarC0, "cid");
            int iC3 = c.c(cVarC0, "name");
            int iC4 = c.c(cVarC0, "desc");
            if (iC != -1 && iC2 != -1 && iC3 != -1 && iC4 != -1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                while (cVarC0.V()) {
                    if (((int) cVarC0.getLong(iC2)) >= 0) {
                        int i = (int) cVarC0.getLong(iC);
                        String strJ = cVarC0.j(iC3);
                        String str2 = cVarC0.getLong(iC4) > 0 ? "DESC" : "ASC";
                        linkedHashMap.put(Integer.valueOf(i), strJ);
                        linkedHashMap2.put(Integer.valueOf(i), str2);
                    }
                }
                List listP0 = sd.j.p0(linkedHashMap.entrySet(), new a5.f(0));
                ArrayList arrayList = new ArrayList(sd.l.f0(listP0, 10));
                Iterator it = listP0.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Map.Entry) it.next()).getValue());
                }
                List listR0 = sd.j.r0(arrayList);
                List listP02 = sd.j.p0(linkedHashMap2.entrySet(), new a5.f(1));
                ArrayList arrayList2 = new ArrayList(sd.l.f0(listP02, 10));
                Iterator it2 = listP02.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((String) ((Map.Entry) it2.next()).getValue());
                }
                a5.i iVar = new a5.i(str, z10, listR0, sd.j.r0(arrayList2));
                android.support.v4.media.session.b.d(cVarC0, null);
                return iVar;
            }
            android.support.v4.media.session.b.d(cVarC0, null);
            return null;
        } finally {
        }
    }

    public static int B(long j4) {
        if (j4 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j4 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j4;
    }

    public static int[] C(Collection collection) {
        if (collection instanceof xa.b) {
            xa.b bVar = (xa.b) collection;
            return Arrays.copyOfRange(bVar.f14468v, bVar.f14469w, bVar.f14470x);
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            obj.getClass();
            iArr[i] = ((Number) obj).intValue();
        }
        return iArr;
    }

    public static final long D(int i, oe.c cVar) {
        ge.i.e(cVar, "unit");
        return cVar.compareTo(oe.c.SECONDS) <= 0 ? o(e.d(i, cVar, oe.c.NANOSECONDS)) : E(i, cVar);
    }

    public static final long E(long j4, oe.c cVar) {
        ge.i.e(cVar, "unit");
        oe.c cVar2 = oe.c.NANOSECONDS;
        long jD = e.d(4611686018426999999L, cVar2, cVar);
        if ((-jD) <= j4 && j4 <= jD) {
            return o(e.d(j4, cVar, cVar2));
        }
        oe.c cVar3 = oe.c.MILLISECONDS;
        ge.i.e(cVar3, "targetUnit");
        return n(f.h(cVar3.f9774v.convert(j4, cVar.f9774v)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Integer F(java.lang.String r19) {
        /*
            r0 = r19
            r0.getClass()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L10
        Lb:
            r0 = 0
            r16 = 0
            goto L86
        L10:
            r1 = 0
            char r3 = r0.charAt(r1)
            r4 = 45
            if (r3 != r4) goto L1a
            r1 = 1
        L1a:
            int r3 = r0.length()
            if (r1 != r3) goto L21
            goto Lb
        L21:
            int r3 = r1 + 1
            char r4 = r0.charAt(r1)
            r5 = -1
            r6 = 128(0x80, float:1.8E-43)
            if (r4 >= r6) goto L31
            byte[] r7 = xa.c.f14471a
            r4 = r7[r4]
            goto L34
        L31:
            byte[] r4 = xa.c.f14471a
            r4 = r5
        L34:
            if (r4 < 0) goto L60
            r7 = 10
            if (r4 < r7) goto L3b
            goto L60
        L3b:
            int r4 = -r4
            long r8 = (long) r4
            long r10 = (long) r7
            r12 = -9223372036854775808
            long r14 = r12 / r10
        L42:
            int r4 = r0.length()
            if (r3 >= r4) goto L73
            int r4 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 >= r6) goto L55
            byte[] r16 = xa.c.f14471a
            r3 = r16[r3]
            goto L58
        L55:
            byte[] r3 = xa.c.f14471a
            r3 = r5
        L58:
            if (r3 < 0) goto L60
            if (r3 >= r7) goto L60
            int r16 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r16 >= 0) goto L63
        L60:
            r16 = 0
            goto L6d
        L63:
            long r8 = r8 * r10
            r16 = 0
            long r2 = (long) r3
            long r17 = r2 + r12
            int r17 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r17 >= 0) goto L70
        L6d:
            r0 = r16
            goto L86
        L70:
            long r8 = r8 - r2
            r3 = r4
            goto L42
        L73:
            r16 = 0
            if (r1 == 0) goto L7c
            java.lang.Long r0 = java.lang.Long.valueOf(r8)
            goto L86
        L7c:
            int r0 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r0 != 0) goto L81
            goto L6d
        L81:
            long r0 = -r8
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L86:
            if (r0 == 0) goto L9f
            long r1 = r0.longValue()
            int r3 = r0.intValue()
            long r3 = (long) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L96
            goto L9f
        L96:
            int r0 = r0.intValue()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        L9f:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.d.F(java.lang.String):java.lang.Integer");
    }

    public static int G(int i) {
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

    public static re.c a(int i, re.a aVar, int i10) {
        int i11 = i10 & 2;
        re.a aVar2 = re.a.f11004v;
        if (i11 != 0) {
            aVar = aVar2;
        }
        if (i == -2) {
            if (aVar != aVar2) {
                return new re.m(1, aVar);
            }
            re.g.f11035q.getClass();
            return new re.c(re.f.f11034b);
        }
        if (i != -1) {
            return i != 0 ? i != Integer.MAX_VALUE ? aVar == aVar2 ? new re.c(i) : new re.m(i, aVar) : new re.c(Integer.MAX_VALUE) : aVar == aVar2 ? new re.c(0) : new re.m(1, aVar);
        }
        if (aVar == aVar2) {
            return new re.m(1, re.a.f11005w);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }

    public static void b(Context context, String str, String str2, String str3, String str4) {
        HashSet hashSet = new HashSet(t(context).getStringSet("list", new HashSet()));
        hashSet.add(str + "*" + str2 + "*" + str3 + "*" + str4);
        t(context).edit().putStringSet("list", hashSet).apply();
    }

    public static List c(int... iArr) {
        return iArr.length == 0 ? Collections.EMPTY_LIST : new xa.b(0, iArr.length, iArr);
    }

    public static String d(int i, int i10, String str) {
        if (i < 0) {
            return e.i("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i10 >= 0) {
            return e.i("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i10));
        }
        throw new IllegalArgumentException(l0.e.g(i10, "negative size: "));
    }

    public static void e(long j4, String str, boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException(e.i(str, Long.valueOf(j4)));
        }
    }

    public static void f(String str, boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void g(int i, int i10) {
        String strI;
        if (i < 0 || i >= i10) {
            if (i < 0) {
                strI = e.i("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else {
                if (i10 < 0) {
                    throw new IllegalArgumentException(l0.e.g(i10, "negative size: "));
                }
                strI = e.i("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i10));
            }
            throw new IndexOutOfBoundsException(strI);
        }
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void i(int i, int i10) {
        if (i < 0 || i > i10) {
            throw new IndexOutOfBoundsException(d(i, i10, "index"));
        }
    }

    public static void j(int i, int i10, int i11) {
        if (i < 0 || i10 < i || i10 > i11) {
            throw new IndexOutOfBoundsException((i < 0 || i > i11) ? d(i, i11, "start index") : (i10 < 0 || i10 > i11) ? d(i10, i11, "end index") : e.i("end index (%s) must not be less than start index (%s)", Integer.valueOf(i10), Integer.valueOf(i)));
        }
    }

    public static void k(String str, boolean z10) {
        if (!z10) {
            throw new IllegalStateException(str);
        }
    }

    public static int l(long j4) {
        int i = (int) j4;
        e(j4, "Out of range: %s", ((long) i) == j4);
        return i;
    }

    public static final Object m(t tVar, fe.l lVar, vd.c cVar) {
        h.o oVar;
        if (tVar.m() && tVar.p() && tVar.n()) {
            return lVar.a(cVar);
        }
        if (cVar.h().C(w.f14006v) == null) {
            return lVar.a(cVar);
        }
        d1.e eVar = new d1.e(lVar, (vd.c) null, 11);
        b0 b0Var = (b0) cVar.h().C(b0.f13922w);
        vd.e eVar2 = b0Var != null ? b0Var.f13923v : null;
        if (eVar2 != null) {
            return x.s(eVar2, eVar, cVar);
        }
        pe.h hVar = new pe.h(1, u8.a.t(cVar));
        hVar.w();
        try {
            oVar = tVar.f13992c;
        } catch (RejectedExecutionException e9) {
            hVar.q(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e9));
        }
        if (oVar != null) {
            oVar.execute(new v1(14, hVar, tVar, eVar, false));
            return hVar.v();
        }
        ge.i.i("internalTransactionExecutor");
        throw null;
    }

    public static final long n(long j4) {
        long j7 = (j4 << 1) + 1;
        int i = oe.a.f9767y;
        int i10 = oe.b.f9769a;
        return j7;
    }

    public static final long o(long j4) {
        long j7 = j4 << 1;
        int i = oe.a.f9767y;
        int i10 = oe.b.f9769a;
        return j7;
    }

    public static int p(byte b8, byte b10, byte b11, byte b12) {
        return (b8 << 24) | ((b10 & 255) << 16) | ((b11 & 255) << 8) | (b12 & 255);
    }

    public static Set r() {
        try {
            Object objInvoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
            if (objInvoke == null) {
                return Collections.EMPTY_SET;
            }
            Set set = (Set) objInvoke;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.EMPTY_SET;
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }

    public static String s(Context context) {
        return t(context).getString("api_host", "https://error_pro.com");
    }

    public static SharedPreferences t(Context context) {
        return context.getSharedPreferences("DataPreferences", 0);
    }

    public static SharedPreferences.Editor u(Context context) {
        return t(context).edit();
    }

    public static int v(int[] iArr, int i, int i10, int i11) {
        while (i10 < i11) {
            if (iArr[i10] == i) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final byte[] y(FileInputStream fileInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, fileInputStream.available()));
        byte[] bArr = new byte[8192];
        int i = fileInputStream.read(bArr);
        while (i >= 0) {
            byteArrayOutputStream.write(bArr, 0, i);
            i = fileInputStream.read(bArr);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ge.i.d(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static final List z(c5.c cVar) {
        int iC = c.c(cVar, "id");
        int iC2 = c.c(cVar, "seq");
        int iC3 = c.c(cVar, "from");
        int iC4 = c.c(cVar, "to");
        td.c cVarH = n5.a.h();
        while (cVar.V()) {
            cVarH.add(new a5.e((int) cVar.getLong(iC), (int) cVar.getLong(iC2), cVar.j(iC3), cVar.j(iC4)));
        }
        return sd.j.o0(n5.a.a(cVarH));
    }

    public abstract void q(v vVar, float f, float f10);

    public abstract void w(int i);

    public abstract void x(Typeface typeface, boolean z10);
}
