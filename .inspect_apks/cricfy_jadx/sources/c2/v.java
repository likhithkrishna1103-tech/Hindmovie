package c2;

import android.database.SQLException;
import android.os.ConditionVariable;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;
import ua.m0;
import ua.n1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashSet f2048j = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f2049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f2050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f2051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f2052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f2053e;
    public final Random f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f2054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2055h;
    public a i;

    public v(File file, s sVar, a2.b bVar) {
        boolean zAdd;
        o oVar = new o(bVar, file);
        g gVar = new g(bVar);
        synchronized (v.class) {
            zAdd = f2048j.add(file.getAbsoluteFile());
        }
        if (!zAdd) {
            throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
        }
        this.f2049a = file;
        this.f2050b = sVar;
        this.f2051c = oVar;
        this.f2052d = gVar;
        this.f2053e = new HashMap();
        this.f = new Random();
        this.f2054g = true;
        this.f2055h = -1L;
        ConditionVariable conditionVariable = new ConditionVariable();
        new u(this, conditionVariable).start();
        conditionVariable.block();
    }

    public static void a(v vVar) {
        long j4;
        g gVar = vVar.f2052d;
        o oVar = vVar.f2051c;
        File file = vVar.f2049a;
        if (!file.exists()) {
            try {
                e(file);
            } catch (a e9) {
                vVar.i = e9;
                return;
            }
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            String str = "Failed to list cache directory files: " + file;
            y1.b.g("SimpleCache", str);
            vVar.i = new a(str);
            return;
        }
        int length = fileArrListFiles.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                j4 = -1;
                break;
            }
            File file2 = fileArrListFiles[i];
            String name = file2.getName();
            if (name.endsWith(".uid")) {
                try {
                    j4 = Long.parseLong(name.substring(0, name.indexOf(46)), 16);
                    break;
                } catch (NumberFormatException unused) {
                    y1.b.g("SimpleCache", "Malformed UID file: " + file2);
                    file2.delete();
                }
            }
            i++;
        }
        vVar.f2055h = j4;
        if (j4 == -1) {
            try {
                vVar.f2055h = f(file);
            } catch (IOException e10) {
                String str2 = "Failed to create cache UID: " + file;
                y1.b.h("SimpleCache", str2, e10);
                vVar.i = new a(str2, e10);
                return;
            }
        }
        try {
            oVar.q(vVar.f2055h);
            if (gVar != null) {
                gVar.c(vVar.f2055h);
                HashMap mapB = gVar.b();
                vVar.i(file, true, fileArrListFiles, mapB);
                gVar.d(mapB.keySet());
            } else {
                vVar.i(file, true, fileArrListFiles, null);
            }
            n1 it = m0.k(((HashMap) oVar.f2035b).keySet()).iterator();
            while (it.hasNext()) {
                oVar.t((String) it.next());
            }
            try {
                oVar.A();
            } catch (IOException e11) {
                y1.b.h("SimpleCache", "Storing index file failed", e11);
            }
        } catch (IOException e12) {
            String str3 = "Failed to initialize cache indices: " + file;
            y1.b.h("SimpleCache", str3, e12);
            vVar.i = new a(str3, e12);
        }
    }

    public static void e(File file) throws a {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        y1.b.g("SimpleCache", str);
        throw new a(str);
    }

    public static long f(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, l0.e.j(Long.toString(jAbs, 16), ".uid"));
        if (file2.createNewFile()) {
            return jAbs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    public final void b(w wVar) {
        String str = wVar.f2012v;
        this.f2051c.m(str).f2021c.add(wVar);
        ArrayList arrayList = (ArrayList) this.f2053e.get(str);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((s) arrayList.get(size)).b(this, wVar);
            }
        }
        this.f2050b.b(this, wVar);
    }

    public final synchronized void c(String str, g gVar) {
        d();
        o oVar = this.f2051c;
        k kVarM = oVar.m(str);
        q qVar = kVarM.f2023e;
        q qVarA = qVar.a(gVar);
        kVarM.f2023e = qVarA;
        if (!qVarA.equals(qVar)) {
            ((n) oVar.f).c(kVarM);
        }
        try {
            this.f2051c.A();
        } catch (IOException e9) {
            throw new a(e9);
        }
    }

    public final synchronized void d() {
        a aVar = this.i;
        if (aVar != null) {
            throw aVar;
        }
    }

    public final synchronized q g(String str) {
        k kVarL;
        kVarL = this.f2051c.l(str);
        return kVarL != null ? kVarL.f2023e : q.f2040c;
    }

    public final w h(long j4, long j7, String str) {
        w wVar;
        long j10;
        k kVarL = this.f2051c.l(str);
        if (kVarL == null) {
            return new w(str, j4, j7, -9223372036854775807L, null);
        }
        while (true) {
            w wVar2 = new w(kVarL.f2020b, j4, -1L, -9223372036854775807L, null);
            TreeSet treeSet = kVarL.f2021c;
            wVar = (w) treeSet.floor(wVar2);
            if (wVar == null || wVar.f2013w + wVar.f2014x <= j4) {
                w wVar3 = (w) treeSet.ceiling(wVar2);
                if (wVar3 != null) {
                    long jMin = wVar3.f2013w - j4;
                    if (j7 != -1) {
                        jMin = Math.min(jMin, j7);
                    }
                    j10 = jMin;
                } else {
                    j10 = j7;
                }
                wVar = new w(kVarL.f2020b, j4, j10, -9223372036854775807L, null);
            }
            if (!wVar.f2015y) {
                break;
            }
            File file = wVar.f2016z;
            file.getClass();
            if (file.length() == wVar.f2014x) {
                break;
            }
            l();
        }
        return wVar;
    }

    public final void i(File file, boolean z10, File[] fileArr, Map map) {
        long j4;
        long j7;
        if (fileArr == null || fileArr.length == 0) {
            if (z10) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z10 && name.indexOf(46) == -1) {
                i(file2, false, file2.listFiles(), map);
            } else if (!z10 || (!name.startsWith("cached_content_index.exi") && !name.endsWith(".uid"))) {
                f fVar = map != null ? (f) map.remove(name) : null;
                if (fVar != null) {
                    j4 = fVar.f2006a;
                    j7 = fVar.f2007b;
                } else {
                    j4 = -1;
                    j7 = -9223372036854775807L;
                }
                w wVarB = w.b(file2, j4, j7, this.f2051c);
                if (wVarB != null) {
                    b(wVarB);
                } else {
                    file2.delete();
                }
            }
        }
    }

    public final synchronized void j(w wVar) {
        k kVarL = this.f2051c.l(wVar.f2012v);
        kVarL.getClass();
        long j4 = wVar.f2013w;
        ArrayList arrayList = kVarL.f2022d;
        for (int i = 0; i < arrayList.size(); i++) {
            if (((j) arrayList.get(i)).f2017a == j4) {
                arrayList.remove(i);
                this.f2051c.t(kVarL.f2020b);
                notifyAll();
            }
        }
        throw new IllegalStateException();
    }

    public final void k(i iVar) {
        String str = iVar.f2012v;
        long j4 = iVar.f2014x;
        File file = iVar.f2016z;
        o oVar = this.f2051c;
        k kVarL = oVar.l(str);
        if (kVarL == null || !kVarL.f2021c.remove(iVar)) {
            return;
        }
        if (file != null) {
            file.delete();
        }
        g gVar = this.f2052d;
        if (gVar != null) {
            file.getClass();
            String name = file.getName();
            try {
                ((String) gVar.f2010b).getClass();
                try {
                    ((a2.b) gVar.f2009a).getWritableDatabase().delete((String) gVar.f2010b, "name = ?", new String[]{name});
                } catch (SQLException e9) {
                    throw new a2.a(e9);
                }
            } catch (IOException unused) {
                l0.e.r("Failed to remove file index entry for: ", name, "SimpleCache");
            }
        }
        oVar.t(kVarL.f2020b);
        ArrayList arrayList = (ArrayList) this.f2053e.get(iVar.f2012v);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                s sVar = (s) arrayList.get(size);
                sVar.f2043a.remove(iVar);
                sVar.f2044b -= j4;
            }
        }
        s sVar2 = this.f2050b;
        sVar2.f2043a.remove(iVar);
        sVar2.f2044b -= j4;
    }

    public final void l() {
        ArrayList arrayList = new ArrayList();
        Iterator it = Collections.unmodifiableCollection(((HashMap) this.f2051c.f2035b).values()).iterator();
        while (it.hasNext()) {
            for (i iVar : ((k) it.next()).f2021c) {
                File file = iVar.f2016z;
                file.getClass();
                if (file.length() != iVar.f2014x) {
                    arrayList.add(iVar);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            k((i) arrayList.get(i));
        }
    }

    public final synchronized w m(long j4, long j7, String str) {
        d();
        w wVarH = h(j4, j7, str);
        if (wVarH.f2015y) {
            return n(str, wVarH);
        }
        k kVarM = this.f2051c.m(str);
        long j10 = wVarH.f2014x;
        ArrayList arrayList = kVarM.f2022d;
        for (int i = 0; i < arrayList.size(); i++) {
            j jVar = (j) arrayList.get(i);
            long j11 = jVar.f2017a;
            if (j11 <= j4) {
                long j12 = jVar.f2018b;
                if (j12 == -1 || j11 + j12 > j4) {
                    return null;
                }
            } else {
                if (j10 == -1 || j4 + j10 > j11) {
                    return null;
                }
            }
        }
        arrayList.add(new j(j4, j10));
        return wVarH;
    }

    public final w n(String str, w wVar) {
        boolean z10;
        File file;
        long j4 = wVar.f2014x;
        File file2 = wVar.f2016z;
        if (!this.f2054g) {
            return wVar;
        }
        file2.getClass();
        String name = file2.getName();
        long j7 = wVar.f2014x;
        long jCurrentTimeMillis = System.currentTimeMillis();
        g gVar = this.f2052d;
        if (gVar != null) {
            try {
                gVar.e(j7, jCurrentTimeMillis, name);
            } catch (IOException unused) {
                jCurrentTimeMillis = jCurrentTimeMillis;
                y1.b.p("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z10 = false;
        } else {
            z10 = true;
        }
        k kVarL = this.f2051c.l(str);
        kVarL.getClass();
        TreeSet treeSet = kVarL.f2021c;
        y1.d.g(treeSet.remove(wVar));
        file2.getClass();
        if (z10) {
            File parentFile = file2.getParentFile();
            parentFile.getClass();
            File fileC = w.c(parentFile, kVarL.f2019a, wVar.f2013w, jCurrentTimeMillis);
            if (file2.renameTo(fileC)) {
                file = fileC;
            } else {
                y1.b.p("CachedContent", "Failed to rename " + file2 + " to " + fileC);
                file = file2;
            }
        } else {
            file = file2;
        }
        y1.d.g(wVar.f2015y);
        w wVar2 = new w(wVar.f2012v, wVar.f2013w, wVar.f2014x, jCurrentTimeMillis, file);
        treeSet.add(wVar2);
        ArrayList arrayList = (ArrayList) this.f2053e.get(wVar.f2012v);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                s sVar = (s) arrayList.get(size);
                sVar.f2043a.remove(wVar);
                sVar.f2044b -= j4;
                sVar.b(this, wVar2);
            }
        }
        s sVar2 = this.f2050b;
        sVar2.f2043a.remove(wVar);
        sVar2.f2044b -= j4;
        sVar2.b(this, wVar2);
        return wVar2;
    }
}
