package w1;

import aa.o0;
import aa.q1;
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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class u implements b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashSet f13558j = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f13559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f13560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b2.g f13561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f13562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f13563e;
    public final Random f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f13564g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f13565h;
    public a i;

    public u(File file, r rVar, u1.a aVar) {
        boolean zAdd;
        b2.g gVar = new b2.g(aVar, file);
        g gVar2 = new g(aVar);
        synchronized (u.class) {
            zAdd = f13558j.add(file.getAbsoluteFile());
        }
        if (!zAdd) {
            throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
        }
        this.f13559a = file;
        this.f13560b = rVar;
        this.f13561c = gVar;
        this.f13562d = gVar2;
        this.f13563e = new HashMap();
        this.f = new Random();
        this.f13564g = true;
        this.f13565h = -1L;
        ConditionVariable conditionVariable = new ConditionVariable();
        new t(this, conditionVariable).start();
        conditionVariable.block();
    }

    public static void a(u uVar) {
        long j5;
        g gVar = uVar.f13562d;
        b2.g gVar2 = uVar.f13561c;
        File file = uVar.f13559a;
        if (!file.exists()) {
            try {
                e(file);
            } catch (a e10) {
                uVar.i = e10;
                return;
            }
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            String str = "Failed to list cache directory files: " + file;
            s1.b.g("SimpleCache", str);
            uVar.i = new a(str);
            return;
        }
        int length = fileArrListFiles.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                j5 = -1;
                break;
            }
            File file2 = fileArrListFiles[i];
            String name = file2.getName();
            if (name.endsWith(".uid")) {
                try {
                    j5 = Long.parseLong(name.substring(0, name.indexOf(46)), 16);
                    break;
                } catch (NumberFormatException unused) {
                    s1.b.g("SimpleCache", "Malformed UID file: " + file2);
                    file2.delete();
                }
            }
            i++;
        }
        uVar.f13565h = j5;
        if (j5 == -1) {
            try {
                uVar.f13565h = f(file);
            } catch (IOException e11) {
                String str2 = "Failed to create cache UID: " + file;
                s1.b.h("SimpleCache", str2, e11);
                uVar.i = new a(str2, e11);
                return;
            }
        }
        try {
            gVar2.q(uVar.f13565h);
            if (gVar != null) {
                gVar.c(uVar.f13565h);
                HashMap mapB = gVar.b();
                uVar.i(file, true, fileArrListFiles, mapB);
                gVar.d(mapB.keySet());
            } else {
                uVar.i(file, true, fileArrListFiles, null);
            }
            q1 it = o0.r(((HashMap) gVar2.f1737b).keySet()).iterator();
            while (it.hasNext()) {
                gVar2.s((String) it.next());
            }
            try {
                gVar2.y();
            } catch (IOException e12) {
                s1.b.h("SimpleCache", "Storing index file failed", e12);
            }
        } catch (IOException e13) {
            String str3 = "Failed to initialize cache indices: " + file;
            s1.b.h("SimpleCache", str3, e13);
            uVar.i = new a(str3, e13);
        }
    }

    public static void e(File file) throws a {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        s1.b.g("SimpleCache", str);
        throw new a(str);
    }

    public static long f(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, e6.j.m(Long.toString(jAbs, 16), ".uid"));
        if (file2.createNewFile()) {
            return jAbs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    public final void b(v vVar) {
        String str = vVar.f13527u;
        this.f13561c.l(str).f13537c.add(vVar);
        ArrayList arrayList = (ArrayList) this.f13563e.get(str);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((r) arrayList.get(size)).b(this, vVar);
            }
        }
        this.f13560b.b(this, vVar);
    }

    public final synchronized void c(String str, g gVar) {
        d();
        b2.g gVar2 = this.f13561c;
        k kVarL = gVar2.l(str);
        p pVar = kVarL.f13539e;
        p pVarA = pVar.a(gVar);
        kVarL.f13539e = pVarA;
        if (!pVarA.equals(pVar)) {
            ((n) gVar2.f).a(kVarL);
        }
        try {
            this.f13561c.y();
        } catch (IOException e10) {
            throw new a(e10);
        }
    }

    public final synchronized void d() {
        a aVar = this.i;
        if (aVar != null) {
            throw aVar;
        }
    }

    public final synchronized p g(String str) {
        k kVarK;
        kVarK = this.f13561c.k(str);
        return kVarK != null ? kVarK.f13539e : p.f13550c;
    }

    public final v h(long j5, long j8, String str) {
        v vVar;
        long j10;
        k kVarK = this.f13561c.k(str);
        if (kVarK == null) {
            return new v(str, j5, j8, -9223372036854775807L, null);
        }
        while (true) {
            v vVar2 = new v(kVarK.f13536b, j5, -1L, -9223372036854775807L, null);
            TreeSet treeSet = kVarK.f13537c;
            vVar = (v) treeSet.floor(vVar2);
            if (vVar == null || vVar.f13528v + vVar.f13529w <= j5) {
                v vVar3 = (v) treeSet.ceiling(vVar2);
                if (vVar3 != null) {
                    long jMin = vVar3.f13528v - j5;
                    if (j8 != -1) {
                        jMin = Math.min(jMin, j8);
                    }
                    j10 = jMin;
                } else {
                    j10 = j8;
                }
                vVar = new v(kVarK.f13536b, j5, j10, -9223372036854775807L, null);
            }
            if (!vVar.f13530x) {
                break;
            }
            File file = vVar.f13531y;
            file.getClass();
            if (file.length() == vVar.f13529w) {
                break;
            }
            l();
        }
        return vVar;
    }

    public final void i(File file, boolean z2, File[] fileArr, Map map) {
        long j5;
        long j8;
        if (fileArr == null || fileArr.length == 0) {
            if (z2) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z2 && name.indexOf(46) == -1) {
                i(file2, false, file2.listFiles(), map);
            } else if (!z2 || (!name.startsWith("cached_content_index.exi") && !name.endsWith(".uid"))) {
                f fVar = map != null ? (f) map.remove(name) : null;
                if (fVar != null) {
                    j5 = fVar.f13521a;
                    j8 = fVar.f13522b;
                } else {
                    j5 = -1;
                    j8 = -9223372036854775807L;
                }
                v vVarB = v.b(file2, j5, j8, this.f13561c);
                if (vVarB != null) {
                    b(vVarB);
                } else {
                    file2.delete();
                }
            }
        }
    }

    public final synchronized void j(v vVar) {
        k kVarK = this.f13561c.k(vVar.f13527u);
        kVarK.getClass();
        long j5 = vVar.f13528v;
        ArrayList arrayList = kVarK.f13538d;
        for (int i = 0; i < arrayList.size(); i++) {
            if (((j) arrayList.get(i)).f13533a == j5) {
                arrayList.remove(i);
                this.f13561c.s(kVarK.f13536b);
                notifyAll();
            }
        }
        throw new IllegalStateException();
    }

    public final void k(i iVar) {
        String str = iVar.f13527u;
        long j5 = iVar.f13529w;
        File file = iVar.f13531y;
        b2.g gVar = this.f13561c;
        k kVarK = gVar.k(str);
        if (kVarK == null || !kVarK.f13537c.remove(iVar)) {
            return;
        }
        if (file != null) {
            file.delete();
        }
        g gVar2 = this.f13562d;
        if (gVar2 != null) {
            file.getClass();
            String name = file.getName();
            try {
                ((String) gVar2.f13525b).getClass();
                try {
                    ((u1.a) gVar2.f13524a).getWritableDatabase().delete((String) gVar2.f13525b, "name = ?", new String[]{name});
                } catch (SQLException e10) {
                    throw new c6.c(e10);
                }
            } catch (IOException unused) {
                e6.j.r("Failed to remove file index entry for: ", name, "SimpleCache");
            }
        }
        gVar.s(kVarK.f13536b);
        ArrayList arrayList = (ArrayList) this.f13563e.get(iVar.f13527u);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                r rVar = (r) arrayList.get(size);
                rVar.f13553a.remove(iVar);
                rVar.f13554b -= j5;
            }
        }
        r rVar2 = this.f13560b;
        rVar2.f13553a.remove(iVar);
        rVar2.f13554b -= j5;
    }

    public final void l() {
        ArrayList arrayList = new ArrayList();
        Iterator it = Collections.unmodifiableCollection(((HashMap) this.f13561c.f1737b).values()).iterator();
        while (it.hasNext()) {
            for (i iVar : ((k) it.next()).f13537c) {
                File file = iVar.f13531y;
                file.getClass();
                if (file.length() != iVar.f13529w) {
                    arrayList.add(iVar);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            k((i) arrayList.get(i));
        }
    }

    public final synchronized v m(long j5, long j8, String str) {
        d();
        v vVarH = h(j5, j8, str);
        if (vVarH.f13530x) {
            return n(str, vVarH);
        }
        k kVarL = this.f13561c.l(str);
        long j10 = vVarH.f13529w;
        ArrayList arrayList = kVarL.f13538d;
        for (int i = 0; i < arrayList.size(); i++) {
            j jVar = (j) arrayList.get(i);
            long j11 = jVar.f13533a;
            if (j11 <= j5) {
                long j12 = jVar.f13534b;
                if (j12 == -1 || j11 + j12 > j5) {
                    return null;
                }
            } else {
                if (j10 == -1 || j5 + j10 > j11) {
                    return null;
                }
            }
        }
        arrayList.add(new j(j5, j10));
        return vVarH;
    }

    public final v n(String str, v vVar) {
        boolean z2;
        File file;
        long j5 = vVar.f13529w;
        File file2 = vVar.f13531y;
        if (!this.f13564g) {
            return vVar;
        }
        file2.getClass();
        String name = file2.getName();
        long j8 = vVar.f13529w;
        long jCurrentTimeMillis = System.currentTimeMillis();
        g gVar = this.f13562d;
        if (gVar != null) {
            try {
                gVar.e(j8, jCurrentTimeMillis, name);
            } catch (IOException unused) {
                jCurrentTimeMillis = jCurrentTimeMillis;
                s1.b.p("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z2 = false;
        } else {
            z2 = true;
        }
        k kVarK = this.f13561c.k(str);
        kVarK.getClass();
        TreeSet treeSet = kVarK.f13537c;
        s1.d.g(treeSet.remove(vVar));
        file2.getClass();
        if (z2) {
            File parentFile = file2.getParentFile();
            parentFile.getClass();
            File fileC = v.c(parentFile, kVarK.f13535a, vVar.f13528v, jCurrentTimeMillis);
            if (file2.renameTo(fileC)) {
                file = fileC;
            } else {
                s1.b.p("CachedContent", "Failed to rename " + file2 + " to " + fileC);
                file = file2;
            }
        } else {
            file = file2;
        }
        s1.d.g(vVar.f13530x);
        v vVar2 = new v(vVar.f13527u, vVar.f13528v, vVar.f13529w, jCurrentTimeMillis, file);
        treeSet.add(vVar2);
        ArrayList arrayList = (ArrayList) this.f13563e.get(vVar.f13527u);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                r rVar = (r) arrayList.get(size);
                rVar.f13553a.remove(vVar);
                rVar.f13554b -= j5;
                rVar.b(this, vVar2);
            }
        }
        r rVar2 = this.f13560b;
        rVar2.f13553a.remove(vVar);
        rVar2.f13554b -= j5;
        rVar2.b(this, vVar2);
        return vVar2;
    }
}
