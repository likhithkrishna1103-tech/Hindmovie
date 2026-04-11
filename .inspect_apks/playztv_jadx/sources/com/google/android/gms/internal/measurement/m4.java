package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile z9.g f3096a;

    public static void A(int i, List list, x5 x5Var, boolean z2) throws c6.c {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) x5Var.f3235a;
        int i10 = 0;
        if (!(list instanceof w5)) {
            if (!z2) {
                while (i10 < list.size()) {
                    b5Var.n(i, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            b5Var.r(i, 2);
            int iU = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iU += b5.u(((Long) list.get(i11)).longValue());
            }
            b5Var.q(iU);
            while (i10 < list.size()) {
                b5Var.o(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        w5 w5Var = (w5) list;
        if (!z2) {
            while (i10 < w5Var.f3226w) {
                b5Var.n(i, w5Var.d(i10));
                i10++;
            }
            return;
        }
        b5Var.r(i, 2);
        int iU2 = 0;
        for (int i12 = 0; i12 < w5Var.f3226w; i12++) {
            iU2 += b5.u(w5Var.d(i12));
        }
        b5Var.q(iU2);
        while (i10 < w5Var.f3226w) {
            b5Var.o(w5Var.d(i10));
            i10++;
        }
    }

    public static n a(y3 y3Var) {
        if (y3Var == null) {
            return n.f3106a;
        }
        int i = t4.f3197a[v.e.c(y3Var.o())];
        if (i == 1) {
            return y3Var.v() ? new p(y3Var.q()) : n.f3112h;
        }
        if (i == 2) {
            return y3Var.u() ? new g(Double.valueOf(y3Var.n())) : new g(null);
        }
        if (i == 3) {
            return y3Var.t() ? new f(Boolean.valueOf(y3Var.s())) : new f(null);
        }
        if (i != 4) {
            if (i != 5) {
                throw new IllegalStateException("Invalid entity: ".concat(String.valueOf(y3Var)));
            }
            throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
        }
        List listR = y3Var.r();
        ArrayList arrayList = new ArrayList();
        Iterator it = listR.iterator();
        while (it.hasNext()) {
            arrayList.add(a((y3) it.next()));
        }
        return new q(y3Var.p(), arrayList);
    }

    public static n b(Object obj) {
        if (obj == null) {
            return n.f3107b;
        }
        if (obj instanceof String) {
            return new p((String) obj);
        }
        if (obj instanceof Double) {
            return new g((Double) obj);
        }
        if (obj instanceof Long) {
            return new g(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new g(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new f((Boolean) obj);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            e eVar = new e();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                eVar.s(b(it.next()));
            }
            return eVar;
        }
        m mVar = new m();
        Map map = (Map) obj;
        for (Object string : map.keySet()) {
            n nVarB = b(map.get(string));
            if (string != null) {
                if (!(string instanceof String)) {
                    string = string.toString();
                }
                mVar.h((String) string, nVarB);
            }
        }
        return mVar;
    }

    public static i4 c(Context context, File file) {
        BufferedReader bufferedReader;
        s.i iVar;
        HashMap map;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                iVar = new s.i(0);
                map = new HashMap();
            } finally {
            }
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                Log.w("HermeticFileOverrides", "Parsed " + String.valueOf(file) + " for Android package " + context.getPackageName());
                i4 i4Var = new i4(iVar);
                bufferedReader.close();
                return i4Var;
            }
            String[] strArrSplit = line.split(" ", 3);
            if (strArrSplit.length != 3) {
                Log.e("HermeticFileOverrides", "Invalid: " + line);
            } else {
                String str = new String(strArrSplit[0]);
                String strDecode = Uri.decode(new String(strArrSplit[1]));
                String strDecode2 = (String) map.get(strArrSplit[2]);
                if (strDecode2 == null) {
                    String str2 = new String(strArrSplit[2]);
                    strDecode2 = Uri.decode(str2);
                    if (strDecode2.length() < 1024 || strDecode2 == str2) {
                        map.put(str2, strDecode2);
                    }
                }
                s.i iVar2 = (s.i) iVar.get(str);
                if (iVar2 == null) {
                    iVar2 = new s.i(0);
                    iVar.put(str, iVar2);
                }
                iVar2.put(strDecode, strDecode2);
            }
            throw new RuntimeException(e10);
        }
    }

    public static z9.g d(Context context) {
        File file;
        z9.g jVar = z9.a.f14905u;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            try {
                file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            } catch (RuntimeException e10) {
                Log.e("HermeticFileOverrides", "no data dir", e10);
            }
            z9.g jVar2 = file.exists() ? new z9.j(file) : jVar;
            if (jVar2.b()) {
                jVar = new z9.j(c(context, (File) jVar2.a()));
            }
            return jVar;
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    public static void e(int i, List list, x5 x5Var, boolean z2) throws c6.c {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) x5Var.f3235a;
        if (list instanceof x4) {
            throw new ClassCastException();
        }
        if (!z2) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                boolean zBooleanValue = ((Boolean) list.get(i10)).booleanValue();
                b5Var.r(i, 0);
                b5Var.d(zBooleanValue ? (byte) 1 : (byte) 0);
            }
            return;
        }
        b5Var.r(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Boolean) list.get(i12)).getClass();
            Logger logger = b5.f;
            i11++;
        }
        b5Var.q(i11);
        for (int i13 = 0; i13 < list.size(); i13++) {
            b5Var.d(((Boolean) list.get(i13)).booleanValue() ? (byte) 1 : (byte) 0);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void f(Object obj, Object obj2) {
        j5 j5Var = (j5) obj;
        k6 k6Var = j5Var.zzb;
        k6 k6Var2 = ((j5) obj2).zzb;
        k6 k6Var3 = k6.f;
        if (!k6Var3.equals(k6Var2)) {
            if (k6Var3.equals(k6Var)) {
                int i = k6Var.f3074a + k6Var2.f3074a;
                int[] iArrCopyOf = Arrays.copyOf(k6Var.f3075b, i);
                System.arraycopy(k6Var2.f3075b, 0, iArrCopyOf, k6Var.f3074a, k6Var2.f3074a);
                Object[] objArrCopyOf = Arrays.copyOf(k6Var.f3076c, i);
                System.arraycopy(k6Var2.f3076c, 0, objArrCopyOf, k6Var.f3074a, k6Var2.f3074a);
                k6Var = new k6(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                k6Var.getClass();
                if (!k6Var2.equals(k6Var3)) {
                    if (!k6Var.f3078e) {
                        throw new UnsupportedOperationException();
                    }
                    int i10 = k6Var.f3074a + k6Var2.f3074a;
                    k6Var.b(i10);
                    System.arraycopy(k6Var2.f3075b, 0, k6Var.f3075b, k6Var.f3074a, k6Var2.f3074a);
                    System.arraycopy(k6Var2.f3076c, 0, k6Var.f3076c, k6Var.f3074a, k6Var2.f3074a);
                    k6Var.f3074a = i10;
                }
            }
        }
        j5Var.zzb = k6Var;
    }

    public static boolean g(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int h(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof m5)) {
            int iU = 0;
            while (i < size) {
                iU += b5.u(((Integer) list.get(i)).intValue());
                i++;
            }
            return iU;
        }
        m5 m5Var = (m5) list;
        int iU2 = 0;
        while (i < size) {
            iU2 += b5.u(m5Var.b(i));
            i++;
        }
        return iU2;
    }

    public static void i(int i, List list, x5 x5Var, boolean z2) throws c6.c {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) x5Var.f3235a;
        if (list instanceof c5) {
            throw new ClassCastException();
        }
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                double dDoubleValue = ((Double) list.get(i10)).doubleValue();
                b5Var.getClass();
                b5Var.g(i, Double.doubleToRawLongBits(dDoubleValue));
                i10++;
            }
            return;
        }
        b5Var.r(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Double) list.get(i12)).getClass();
            Logger logger = b5.f;
            i11 += 8;
        }
        b5Var.q(i11);
        while (i10 < list.size()) {
            b5Var.h(Double.doubleToRawLongBits(((Double) list.get(i10)).doubleValue()));
            i10++;
        }
    }

    public static void j(int i, List list, x5 x5Var, boolean z2) throws c6.c {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) x5Var.f3235a;
        int i10 = 0;
        if (!(list instanceof m5)) {
            if (!z2) {
                while (i10 < list.size()) {
                    b5Var.m(i, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            b5Var.r(i, 2);
            int iU = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iU += b5.u(((Integer) list.get(i11)).intValue());
            }
            b5Var.q(iU);
            while (i10 < list.size()) {
                b5Var.l(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        m5 m5Var = (m5) list;
        if (!z2) {
            while (i10 < m5Var.f3100w) {
                b5Var.m(i, m5Var.b(i10));
                i10++;
            }
            return;
        }
        b5Var.r(i, 2);
        int iU2 = 0;
        for (int i12 = 0; i12 < m5Var.f3100w; i12++) {
            iU2 += b5.u(m5Var.b(i12));
        }
        b5Var.q(iU2);
        while (i10 < m5Var.f3100w) {
            b5Var.l(m5Var.b(i10));
            i10++;
        }
    }

    public static void k(int i, List list, x5 x5Var, boolean z2) throws c6.c {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) x5Var.f3235a;
        int i10 = 0;
        if (!(list instanceof m5)) {
            if (!z2) {
                while (i10 < list.size()) {
                    b5Var.f(i, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            b5Var.r(i, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Integer) list.get(i12)).getClass();
                Logger logger = b5.f;
                i11 += 4;
            }
            b5Var.q(i11);
            while (i10 < list.size()) {
                b5Var.e(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        m5 m5Var = (m5) list;
        if (!z2) {
            while (i10 < m5Var.f3100w) {
                b5Var.f(i, m5Var.b(i10));
                i10++;
            }
            return;
        }
        b5Var.r(i, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < m5Var.f3100w; i14++) {
            m5Var.b(i14);
            Logger logger2 = b5.f;
            i13 += 4;
        }
        b5Var.q(i13);
        while (i10 < m5Var.f3100w) {
            b5Var.e(m5Var.b(i10));
            i10++;
        }
    }

    public static int l(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof m5)) {
            int iU = 0;
            while (i < size) {
                iU += b5.u(((Integer) list.get(i)).intValue());
                i++;
            }
            return iU;
        }
        m5 m5Var = (m5) list;
        int iU2 = 0;
        while (i < size) {
            iU2 += b5.u(m5Var.b(i));
            i++;
        }
        return iU2;
    }

    public static void m(int i, List list, x5 x5Var, boolean z2) throws c6.c {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) x5Var.f3235a;
        int i10 = 0;
        if (!(list instanceof w5)) {
            if (!z2) {
                while (i10 < list.size()) {
                    b5Var.g(i, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            b5Var.r(i, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Long) list.get(i12)).getClass();
                Logger logger = b5.f;
                i11 += 8;
            }
            b5Var.q(i11);
            while (i10 < list.size()) {
                b5Var.h(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        w5 w5Var = (w5) list;
        if (!z2) {
            while (i10 < w5Var.f3226w) {
                b5Var.g(i, w5Var.d(i10));
                i10++;
            }
            return;
        }
        b5Var.r(i, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < w5Var.f3226w; i14++) {
            w5Var.d(i14);
            Logger logger2 = b5.f;
            i13 += 8;
        }
        b5Var.q(i13);
        while (i10 < w5Var.f3226w) {
            b5Var.h(w5Var.d(i10));
            i10++;
        }
    }

    public static int n(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof w5)) {
            int iU = 0;
            while (i < size) {
                iU += b5.u(((Long) list.get(i)).longValue());
                i++;
            }
            return iU;
        }
        w5 w5Var = (w5) list;
        int iU2 = 0;
        while (i < size) {
            iU2 += b5.u(w5Var.d(i));
            i++;
        }
        return iU2;
    }

    public static void o(int i, List list, x5 x5Var, boolean z2) throws c6.c {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) x5Var.f3235a;
        if (list instanceof h5) {
            throw new ClassCastException();
        }
        int i10 = 0;
        if (!z2) {
            while (i10 < list.size()) {
                float fFloatValue = ((Float) list.get(i10)).floatValue();
                b5Var.getClass();
                b5Var.f(i, Float.floatToRawIntBits(fFloatValue));
                i10++;
            }
            return;
        }
        b5Var.r(i, 2);
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((Float) list.get(i12)).getClass();
            Logger logger = b5.f;
            i11 += 4;
        }
        b5Var.q(i11);
        while (i10 < list.size()) {
            b5Var.e(Float.floatToRawIntBits(((Float) list.get(i10)).floatValue()));
            i10++;
        }
    }

    public static int p(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof m5)) {
            int iW = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iW += b5.w((iIntValue >> 31) ^ (iIntValue << 1));
                i++;
            }
            return iW;
        }
        m5 m5Var = (m5) list;
        int iW2 = 0;
        while (i < size) {
            int iB = m5Var.b(i);
            iW2 += b5.w((iB >> 31) ^ (iB << 1));
            i++;
        }
        return iW2;
    }

    public static void q(int i, List list, x5 x5Var, boolean z2) throws c6.c {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) x5Var.f3235a;
        int i10 = 0;
        if (!(list instanceof m5)) {
            if (!z2) {
                while (i10 < list.size()) {
                    b5Var.m(i, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            b5Var.r(i, 2);
            int iU = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iU += b5.u(((Integer) list.get(i11)).intValue());
            }
            b5Var.q(iU);
            while (i10 < list.size()) {
                b5Var.l(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        m5 m5Var = (m5) list;
        if (!z2) {
            while (i10 < m5Var.f3100w) {
                b5Var.m(i, m5Var.b(i10));
                i10++;
            }
            return;
        }
        b5Var.r(i, 2);
        int iU2 = 0;
        for (int i12 = 0; i12 < m5Var.f3100w; i12++) {
            iU2 += b5.u(m5Var.b(i12));
        }
        b5Var.q(iU2);
        while (i10 < m5Var.f3100w) {
            b5Var.l(m5Var.b(i10));
            i10++;
        }
    }

    public static int r(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof w5)) {
            int iU = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iU += b5.u((jLongValue >> 63) ^ (jLongValue << 1));
                i++;
            }
            return iU;
        }
        w5 w5Var = (w5) list;
        int iU2 = 0;
        while (i < size) {
            long jD = w5Var.d(i);
            iU2 += b5.u((jD >> 63) ^ (jD << 1));
            i++;
        }
        return iU2;
    }

    public static void s(int i, List list, x5 x5Var, boolean z2) throws c6.c {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) x5Var.f3235a;
        int i10 = 0;
        if (!(list instanceof w5)) {
            if (!z2) {
                while (i10 < list.size()) {
                    b5Var.n(i, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            b5Var.r(i, 2);
            int iU = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iU += b5.u(((Long) list.get(i11)).longValue());
            }
            b5Var.q(iU);
            while (i10 < list.size()) {
                b5Var.o(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        w5 w5Var = (w5) list;
        if (!z2) {
            while (i10 < w5Var.f3226w) {
                b5Var.n(i, w5Var.d(i10));
                i10++;
            }
            return;
        }
        b5Var.r(i, 2);
        int iU2 = 0;
        for (int i12 = 0; i12 < w5Var.f3226w; i12++) {
            iU2 += b5.u(w5Var.d(i12));
        }
        b5Var.q(iU2);
        while (i10 < w5Var.f3226w) {
            b5Var.o(w5Var.d(i10));
            i10++;
        }
    }

    public static int t(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof m5)) {
            int iW = 0;
            while (i < size) {
                iW += b5.w(((Integer) list.get(i)).intValue());
                i++;
            }
            return iW;
        }
        m5 m5Var = (m5) list;
        int iW2 = 0;
        while (i < size) {
            iW2 += b5.w(m5Var.b(i));
            i++;
        }
        return iW2;
    }

    public static void u(int i, List list, x5 x5Var, boolean z2) throws c6.c {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) x5Var.f3235a;
        int i10 = 0;
        if (!(list instanceof m5)) {
            if (!z2) {
                while (i10 < list.size()) {
                    b5Var.f(i, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            b5Var.r(i, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Integer) list.get(i12)).getClass();
                Logger logger = b5.f;
                i11 += 4;
            }
            b5Var.q(i11);
            while (i10 < list.size()) {
                b5Var.e(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        m5 m5Var = (m5) list;
        if (!z2) {
            while (i10 < m5Var.f3100w) {
                b5Var.f(i, m5Var.b(i10));
                i10++;
            }
            return;
        }
        b5Var.r(i, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < m5Var.f3100w; i14++) {
            m5Var.b(i14);
            Logger logger2 = b5.f;
            i13 += 4;
        }
        b5Var.q(i13);
        while (i10 < m5Var.f3100w) {
            b5Var.e(m5Var.b(i10));
            i10++;
        }
    }

    public static int v(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof w5)) {
            int iU = 0;
            while (i < size) {
                iU += b5.u(((Long) list.get(i)).longValue());
                i++;
            }
            return iU;
        }
        w5 w5Var = (w5) list;
        int iU2 = 0;
        while (i < size) {
            iU2 += b5.u(w5Var.d(i));
            i++;
        }
        return iU2;
    }

    public static void w(int i, List list, x5 x5Var, boolean z2) throws c6.c {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) x5Var.f3235a;
        int i10 = 0;
        if (!(list instanceof w5)) {
            if (!z2) {
                while (i10 < list.size()) {
                    b5Var.g(i, ((Long) list.get(i10)).longValue());
                    i10++;
                }
                return;
            }
            b5Var.r(i, 2);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((Long) list.get(i12)).getClass();
                Logger logger = b5.f;
                i11 += 8;
            }
            b5Var.q(i11);
            while (i10 < list.size()) {
                b5Var.h(((Long) list.get(i10)).longValue());
                i10++;
            }
            return;
        }
        w5 w5Var = (w5) list;
        if (!z2) {
            while (i10 < w5Var.f3226w) {
                b5Var.g(i, w5Var.d(i10));
                i10++;
            }
            return;
        }
        b5Var.r(i, 2);
        int i13 = 0;
        for (int i14 = 0; i14 < w5Var.f3226w; i14++) {
            w5Var.d(i14);
            Logger logger2 = b5.f;
            i13 += 8;
        }
        b5Var.q(i13);
        while (i10 < w5Var.f3226w) {
            b5Var.h(w5Var.d(i10));
            i10++;
        }
    }

    public static void x(int i, List list, x5 x5Var, boolean z2) throws c6.c {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) x5Var.f3235a;
        int i10 = 0;
        if (!(list instanceof m5)) {
            if (!z2) {
                while (i10 < list.size()) {
                    int iIntValue = ((Integer) list.get(i10)).intValue();
                    b5Var.t(i, (iIntValue >> 31) ^ (iIntValue << 1));
                    i10++;
                }
                return;
            }
            b5Var.r(i, 2);
            int iW = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                int iIntValue2 = ((Integer) list.get(i11)).intValue();
                iW += b5.w((iIntValue2 >> 31) ^ (iIntValue2 << 1));
            }
            b5Var.q(iW);
            while (i10 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i10)).intValue();
                b5Var.q((iIntValue3 >> 31) ^ (iIntValue3 << 1));
                i10++;
            }
            return;
        }
        m5 m5Var = (m5) list;
        if (!z2) {
            while (i10 < m5Var.f3100w) {
                int iB = m5Var.b(i10);
                b5Var.t(i, (iB >> 31) ^ (iB << 1));
                i10++;
            }
            return;
        }
        b5Var.r(i, 2);
        int iW2 = 0;
        for (int i12 = 0; i12 < m5Var.f3100w; i12++) {
            int iB2 = m5Var.b(i12);
            iW2 += b5.w((iB2 >> 31) ^ (iB2 << 1));
        }
        b5Var.q(iW2);
        while (i10 < m5Var.f3100w) {
            int iB3 = m5Var.b(i10);
            b5Var.q((iB3 >> 31) ^ (iB3 << 1));
            i10++;
        }
    }

    public static void y(int i, List list, x5 x5Var, boolean z2) throws c6.c {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) x5Var.f3235a;
        int i10 = 0;
        if (!(list instanceof w5)) {
            if (!z2) {
                while (i10 < list.size()) {
                    long jLongValue = ((Long) list.get(i10)).longValue();
                    b5Var.n(i, (jLongValue >> 63) ^ (jLongValue << 1));
                    i10++;
                }
                return;
            }
            b5Var.r(i, 2);
            int iU = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                long jLongValue2 = ((Long) list.get(i11)).longValue();
                iU += b5.u((jLongValue2 >> 63) ^ (jLongValue2 << 1));
            }
            b5Var.q(iU);
            while (i10 < list.size()) {
                long jLongValue3 = ((Long) list.get(i10)).longValue();
                b5Var.o((jLongValue3 >> 63) ^ (jLongValue3 << 1));
                i10++;
            }
            return;
        }
        w5 w5Var = (w5) list;
        if (!z2) {
            while (i10 < w5Var.f3226w) {
                long jD = w5Var.d(i10);
                b5Var.n(i, (jD >> 63) ^ (jD << 1));
                i10++;
            }
            return;
        }
        b5Var.r(i, 2);
        int iU2 = 0;
        for (int i12 = 0; i12 < w5Var.f3226w; i12++) {
            long jD2 = w5Var.d(i12);
            iU2 += b5.u((jD2 >> 63) ^ (jD2 << 1));
        }
        b5Var.q(iU2);
        while (i10 < w5Var.f3226w) {
            long jD3 = w5Var.d(i10);
            b5Var.o((jD3 >> 63) ^ (jD3 << 1));
            i10++;
        }
    }

    public static void z(int i, List list, x5 x5Var, boolean z2) throws c6.c {
        if (list == null || list.isEmpty()) {
            return;
        }
        b5 b5Var = (b5) x5Var.f3235a;
        int i10 = 0;
        if (!(list instanceof m5)) {
            if (!z2) {
                while (i10 < list.size()) {
                    b5Var.t(i, ((Integer) list.get(i10)).intValue());
                    i10++;
                }
                return;
            }
            b5Var.r(i, 2);
            int iW = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                iW += b5.w(((Integer) list.get(i11)).intValue());
            }
            b5Var.q(iW);
            while (i10 < list.size()) {
                b5Var.q(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return;
        }
        m5 m5Var = (m5) list;
        if (!z2) {
            while (i10 < m5Var.f3100w) {
                b5Var.t(i, m5Var.b(i10));
                i10++;
            }
            return;
        }
        b5Var.r(i, 2);
        int iW2 = 0;
        for (int i12 = 0; i12 < m5Var.f3100w; i12++) {
            iW2 += b5.w(m5Var.b(i12));
        }
        b5Var.q(iW2);
        while (i10 < m5Var.f3100w) {
            b5Var.q(m5Var.b(i10));
            i10++;
        }
    }
}
