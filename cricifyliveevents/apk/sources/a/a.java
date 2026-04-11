package a;

import a3.k0;
import android.database.Cursor;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import c.h0;
import com.google.android.gms.internal.measurement.j4;
import fe.p;
import ge.i;
import ge.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l0.e;
import ne.o;
import pe.x;
import q6.f;
import q6.l;
import q6.q;
import r6.b;
import x3.c;
import x3.g;
import y1.d;
import y1.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static Object a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0082 -> B:25:0x0065). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0085 -> B:25:0x0065). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(java.util.List r6, d1.l r7, xd.c r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof d1.f
            if (r0 == 0) goto L13
            r0 = r8
            d1.f r0 = (d1.f) r0
            int r1 = r0.B
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.B = r1
            goto L18
        L13:
            d1.f r0 = new d1.f
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.A
            int r1 = r0.B
            r2 = 2
            r3 = 1
            wd.a r4 = wd.a.f14143v
            if (r1 == 0) goto L42
            if (r1 == r3) goto L3a
            if (r1 != r2) goto L32
            java.util.Iterator r6 = r0.f3227z
            java.io.Serializable r7 = r0.f3226y
            ge.p r7 = (ge.p) r7
            com.bumptech.glide.c.C(r8)     // Catch: java.lang.Throwable -> L30
            goto L65
        L30:
            r8 = move-exception
            goto L7e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            java.io.Serializable r6 = r0.f3226y
            java.util.List r6 = (java.util.List) r6
            com.bumptech.glide.c.C(r8)
            goto L5c
        L42:
            com.bumptech.glide.c.C(r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            d1.h r1 = new d1.h
            r5 = 0
            r1.<init>(r6, r8, r5)
            r0.f3226y = r8
            r0.B = r3
            java.lang.Object r6 = r7.a(r1, r0)
            if (r6 != r4) goto L5b
            goto L93
        L5b:
            r6 = r8
        L5c:
            ge.p r7 = new ge.p
            r7.<init>()
            java.util.Iterator r6 = r6.iterator()
        L65:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L8b
            java.lang.Object r8 = r6.next()
            fe.l r8 = (fe.l) r8
            r0.f3226y = r7     // Catch: java.lang.Throwable -> L30
            r0.f3227z = r6     // Catch: java.lang.Throwable -> L30
            r0.B = r2     // Catch: java.lang.Throwable -> L30
            java.lang.Object r8 = r8.a(r0)     // Catch: java.lang.Throwable -> L30
            if (r8 != r4) goto L65
            goto L93
        L7e:
            java.lang.Object r1 = r7.f5254v
            if (r1 != 0) goto L85
            r7.f5254v = r8
            goto L65
        L85:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            ab.b.c(r1, r8)
            goto L65
        L8b:
            java.lang.Object r6 = r7.f5254v
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            if (r6 != 0) goto L94
            rd.l r4 = rd.l.f11003a
        L93:
            return r4
        L94:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.b(java.util.List, d1.l, xd.c):java.lang.Object");
    }

    public static final int d(Cursor cursor, String str) {
        String string;
        i.e(cursor, "c");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0) {
            columnIndex = cursor.getColumnIndex("`" + str + '`');
            if (columnIndex < 0) {
                if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
                    String[] columnNames = cursor.getColumnNames();
                    i.b(columnNames);
                    String strConcat = ".".concat(str);
                    String str2 = "." + str + '`';
                    int length = columnNames.length;
                    int i = 0;
                    int i10 = 0;
                    while (i10 < length) {
                        String str3 = columnNames[i10];
                        int i11 = i + 1;
                        if (str3.length() >= str.length() + 2 && (o.V(str3, strConcat) || (str3.charAt(0) == '`' && o.V(str3, str2)))) {
                            columnIndex = i;
                            break;
                        }
                        i10++;
                        i = i11;
                    }
                    columnIndex = -1;
                } else {
                    columnIndex = -1;
                }
            }
        }
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames2 = cursor.getColumnNames();
            i.d(columnNames2, "getColumnNames(...)");
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) "");
            int i12 = 0;
            for (String str4 : columnNames2) {
                i12++;
                if (i12 > 1) {
                    sb.append((CharSequence) ", ");
                }
                u8.a.a(sb, str4, null);
            }
            sb.append((CharSequence) "");
            string = sb.toString();
        } catch (Exception e9) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e9);
            string = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + string);
    }

    public static int e(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 32) {
            return 5;
        }
        if (i == 64) {
            return 6;
        }
        if (i == 128) {
            return 7;
        }
        if (i == 256) {
            return 8;
        }
        if (i == 512) {
            return 9;
        }
        throw new IllegalArgumentException(e.g(i, "type needs to be >= FIRST and <= LAST, type="));
    }

    public static boolean f(byte b8) {
        return b8 > -65;
    }

    public static void g(g gVar, int i, h hVar) {
        long jE = gVar.e(i);
        List listI = gVar.i(jE);
        if (listI.isEmpty()) {
            return;
        }
        if (i == gVar.j() - 1) {
            throw new IllegalStateException();
        }
        long jE2 = gVar.e(i + 1) - gVar.e(i);
        if (jE2 > 0) {
            hVar.accept(new c(jE, jE2, listI));
        }
    }

    public static m6.a h(b bVar, g6.i iVar) {
        return new m6.a(0, q.a(bVar, iVar, 1.0f, f.f10401w, false));
    }

    public static m6.b i(r6.a aVar, g6.i iVar, boolean z10) {
        return new m6.b(4, q.a(aVar, iVar, z10 ? s6.i.c() : 1.0f, f.f10402x, false));
    }

    public static m6.a j(b bVar, g6.i iVar, int i) {
        l lVar = new l();
        lVar.f10418v = i;
        ArrayList arrayListA = q.a(bVar, iVar, 1.0f, lVar, false);
        for (int i10 = 0; i10 < arrayListA.size(); i10++) {
            t6.a aVar = (t6.a) arrayListA.get(i10);
            n6.c cVar = (n6.c) aVar.f11932b;
            n6.c cVar2 = (n6.c) aVar.f11933c;
            if (cVar != null && cVar2 != null) {
                float[] fArr = cVar.f8779a;
                int length = fArr.length;
                float[] fArr2 = cVar2.f8779a;
                if (length != fArr2.length) {
                    int length2 = fArr.length + fArr2.length;
                    float[] fArr3 = new float[length2];
                    System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
                    System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
                    Arrays.sort(fArr3);
                    float f = Float.NaN;
                    int i11 = 0;
                    for (int i12 = 0; i12 < length2; i12++) {
                        float f10 = fArr3[i12];
                        if (f10 != f) {
                            fArr3[i11] = f10;
                            i11++;
                            f = fArr3[i12];
                        }
                    }
                    float[] fArrCopyOfRange = Arrays.copyOfRange(fArr3, 0, i11);
                    aVar = new t6.a(cVar.b(fArrCopyOfRange), cVar2.b(fArrCopyOfRange));
                }
            }
            arrayListA.set(i10, aVar);
        }
        return new m6.a(1, arrayListA);
    }

    public static m6.a k(r6.a aVar, g6.i iVar) {
        return new m6.a(2, q.a(aVar, iVar, 1.0f, f.f10403y, false));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList l(y1.t r30) {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.l(y1.t):java.util.ArrayList");
    }

    public static m6.a m(b bVar, g6.i iVar) {
        return new m6.a(3, q.a(bVar, iVar, s6.i.c(), f.A, true));
    }

    public static int n(k0 k0Var, int i, int i10, int i11) {
        d.b(Math.max(Math.max(i, i10), i11) <= 31);
        int i12 = (1 << i) - 1;
        int i13 = (1 << i10) - 1;
        j4.c(j4.c(i12, i13), 1 << i11);
        if (k0Var.b() < i) {
            return -1;
        }
        int i14 = k0Var.i(i);
        if (i14 == i12) {
            if (k0Var.b() < i10) {
                return -1;
            }
            int i15 = k0Var.i(i10);
            i14 += i15;
            if (i15 == i13) {
                if (k0Var.b() < i11) {
                    return -1;
                }
                return k0Var.i(i11) + i14;
            }
        }
        return i14;
    }

    public static void p(k0 k0Var) {
        k0Var.t(3);
        k0Var.t(8);
        boolean zH = k0Var.h();
        boolean zH2 = k0Var.h();
        if (zH) {
            k0Var.t(5);
        }
        if (zH2) {
            k0Var.t(6);
        }
    }

    public static void q(k0 k0Var) {
        int i;
        int i10 = k0Var.i(2);
        if (i10 == 0) {
            k0Var.t(6);
            return;
        }
        int iN = n(k0Var, 5, 8, 16) + 1;
        if (i10 == 1) {
            k0Var.t(iN * 7);
            return;
        }
        if (i10 == 2) {
            boolean zH = k0Var.h();
            int i11 = zH ? 1 : 5;
            int i12 = zH ? 7 : 5;
            int i13 = zH ? 8 : 6;
            int i14 = 0;
            while (i14 < iN) {
                if (k0Var.h()) {
                    k0Var.t(7);
                    i = 0;
                } else {
                    if (k0Var.i(2) == 3 && k0Var.i(i12) * i11 != 0) {
                        k0Var.s();
                    }
                    i = k0Var.i(i13) * i11;
                    if (i != 0 && i != 180) {
                        k0Var.s();
                    }
                    k0Var.s();
                }
                if (i != 0 && i != 180 && k0Var.h()) {
                    i14++;
                }
                i14++;
            }
        }
    }

    public static final Object r(ue.q qVar, ue.q qVar2, p pVar) throws Throwable {
        Object pVar2;
        Object objP;
        try {
            s.a(2, pVar);
            pVar2 = pVar.j(qVar2, qVar);
        } catch (Throwable th) {
            pVar2 = new pe.p(th, false);
        }
        wd.a aVar = wd.a.f14143v;
        if (pVar2 == aVar || (objP = qVar.P(pVar2)) == x.f10285e) {
            return aVar;
        }
        if (objP instanceof pe.p) {
            throw ((pe.p) objP).f10263a;
        }
        return x.q(objP);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void s(x3.g r12, x3.o r13, y1.h r14) {
        /*
            long r0 = r13.f14315a
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r5 = 0
            if (r4 != 0) goto Le
            r4 = r5
            goto L27
        Le:
            int r4 = r12.a(r0)
            r6 = -1
            if (r4 != r6) goto L19
            int r4 = r12.j()
        L19:
            if (r4 <= 0) goto L27
            int r6 = r4 + (-1)
            long r6 = r12.e(r6)
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 != 0) goto L27
            int r4 = r4 + (-1)
        L27:
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L51
            int r2 = r12.j()
            if (r4 >= r2) goto L51
            java.util.List r11 = r12.i(r0)
            long r2 = r12.e(r4)
            boolean r6 = r11.isEmpty()
            if (r6 != 0) goto L51
            long r7 = r13.f14315a
            int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r6 >= 0) goto L51
            x3.c r6 = new x3.c
            long r9 = r2 - r7
            r6.<init>(r7, r9, r11)
            r14.accept(r6)
            r2 = 1
            goto L52
        L51:
            r2 = r5
        L52:
            r3 = r4
        L53:
            int r6 = r12.j()
            if (r3 >= r6) goto L5f
            g(r12, r3, r14)
            int r3 = r3 + 1
            goto L53
        L5f:
            boolean r13 = r13.f14316b
            if (r13 == 0) goto L87
            if (r2 == 0) goto L67
            int r4 = r4 + (-1)
        L67:
            if (r5 >= r4) goto L6f
            g(r12, r5, r14)
            int r5 = r5 + 1
            goto L67
        L6f:
            if (r2 == 0) goto L87
            x3.c r6 = new x3.c
            java.util.List r11 = r12.i(r0)
            long r7 = r12.e(r4)
            long r12 = r12.e(r4)
            long r9 = r0 - r12
            r6.<init>(r7, r9, r11)
            r14.accept(r6)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.s(x3.g, x3.o, y1.h):void");
    }

    public abstract void o(h0 h0Var, h0 h0Var2, Window window, View view, boolean z10, boolean z11);

    public void c(Window window) {
    }
}
