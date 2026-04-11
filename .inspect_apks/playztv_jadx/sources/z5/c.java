package z5;

import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k8.f1;
import n.a1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Closeable {
    public BufferedWriter C;
    public int E;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final File f14873u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final File f14874v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final File f14875w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final File f14876x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f14878z;
    public long B = 0;
    public final LinkedHashMap D = new LinkedHashMap(0, 0.75f, true);
    public long F = 0;
    public final ThreadPoolExecutor G = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a());
    public final f1 H = new f1(this);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f14877y = 1;
    public final int A = 1;

    public c(File file, long j5) {
        this.f14873u = file;
        this.f14874v = new File(file, "journal");
        this.f14875w = new File(file, "journal.tmp");
        this.f14876x = new File(file, "journal.bkp");
        this.f14878z = j5;
    }

    public static void F(BufferedWriter bufferedWriter) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            bufferedWriter.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static c J(File file, long j5) throws IOException {
        if (j5 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                i0(file2, file3, false);
            }
        }
        c cVar = new c(file, j5);
        if (cVar.f14874v.exists()) {
            try {
                cVar.S();
                cVar.K();
                return cVar;
            } catch (IOException e10) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                cVar.close();
                f.a(cVar.f14873u);
            }
        }
        file.mkdirs();
        c cVar2 = new c(file, j5);
        cVar2.h0();
        return cVar2;
    }

    public static void a(c cVar, a2.c cVar2, boolean z2) {
        synchronized (cVar) {
            b bVar = (b) cVar2.f173v;
            if (bVar.f != cVar2) {
                throw new IllegalStateException();
            }
            if (z2 && !bVar.f14871e) {
                for (int i = 0; i < cVar.A; i++) {
                    if (!((boolean[]) cVar2.f174w)[i]) {
                        cVar2.c();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!bVar.f14870d[i].exists()) {
                        cVar2.c();
                        return;
                    }
                }
            }
            for (int i10 = 0; i10 < cVar.A; i10++) {
                File file = bVar.f14870d[i10];
                if (!z2) {
                    v(file);
                } else if (file.exists()) {
                    File file2 = bVar.f14869c[i10];
                    file.renameTo(file2);
                    long j5 = bVar.f14868b[i10];
                    long length = file2.length();
                    bVar.f14868b[i10] = length;
                    cVar.B = (cVar.B - j5) + length;
                }
            }
            cVar.E++;
            bVar.f = null;
            if (bVar.f14871e || z2) {
                bVar.f14871e = true;
                cVar.C.append((CharSequence) "CLEAN");
                cVar.C.append(' ');
                cVar.C.append((CharSequence) bVar.f14867a);
                cVar.C.append((CharSequence) bVar.a());
                cVar.C.append('\n');
                if (z2) {
                    cVar.F++;
                }
            } else {
                cVar.D.remove(bVar.f14867a);
                cVar.C.append((CharSequence) "REMOVE");
                cVar.C.append(' ');
                cVar.C.append((CharSequence) bVar.f14867a);
                cVar.C.append('\n');
            }
            F(cVar.C);
            if (cVar.B > cVar.f14878z || cVar.H()) {
                cVar.G.submit(cVar.H);
            }
        }
    }

    public static void d(BufferedWriter bufferedWriter) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            bufferedWriter.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void i0(File file, File file2, boolean z2) throws IOException {
        if (z2) {
            v(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void v(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public final synchronized a1 G(String str) {
        if (this.C == null) {
            throw new IllegalStateException("cache is closed");
        }
        b bVar = (b) this.D.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.f14871e) {
            return null;
        }
        for (File file : bVar.f14869c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.E++;
        this.C.append((CharSequence) "READ");
        this.C.append(' ');
        this.C.append((CharSequence) str);
        this.C.append('\n');
        if (H()) {
            this.G.submit(this.H);
        }
        return new a1(bVar.f14869c);
    }

    public final boolean H() {
        int i = this.E;
        return i >= 2000 && i >= this.D.size();
    }

    public final void K() throws IOException {
        v(this.f14875w);
        Iterator it = this.D.values().iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            a2.c cVar = bVar.f;
            int i = this.A;
            int i10 = 0;
            if (cVar == null) {
                while (i10 < i) {
                    this.B += bVar.f14868b[i10];
                    i10++;
                }
            } else {
                bVar.f = null;
                while (i10 < i) {
                    v(bVar.f14869c[i10]);
                    v(bVar.f14870d[i10]);
                    i10++;
                }
                it.remove();
            }
        }
    }

    public final void S() {
        File file = this.f14874v;
        e eVar = new e(new FileInputStream(file), f.f14885a);
        try {
            String strA = eVar.a();
            String strA2 = eVar.a();
            String strA3 = eVar.a();
            String strA4 = eVar.a();
            String strA5 = eVar.a();
            if (!"libcore.io.DiskLruCache".equals(strA) || !"1".equals(strA2) || !Integer.toString(this.f14877y).equals(strA3) || !Integer.toString(this.A).equals(strA4) || !"".equals(strA5)) {
                throw new IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    g0(eVar.a());
                    i++;
                } catch (EOFException unused) {
                    this.E = i - this.D.size();
                    if (eVar.f14884y == -1) {
                        h0();
                    } else {
                        this.C = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), f.f14885a));
                    }
                    try {
                        eVar.close();
                        return;
                    } catch (RuntimeException e10) {
                        throw e10;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                eVar.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.C == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.D.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                a2.c cVar = ((b) obj).f;
                if (cVar != null) {
                    cVar.c();
                }
            }
            j0();
            d(this.C);
            this.C = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void g0(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        LinkedHashMap linkedHashMap = this.D;
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        b bVar = (b) linkedHashMap.get(strSubstring);
        if (bVar == null) {
            bVar = new b(this, strSubstring);
            linkedHashMap.put(strSubstring, bVar);
        }
        if (iIndexOf2 == -1 || iIndexOf != 5 || !str.startsWith("CLEAN")) {
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                bVar.f = new a2.c(this, bVar);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
        bVar.f14871e = true;
        bVar.f = null;
        if (strArrSplit.length != bVar.f14872g.A) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
        }
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            try {
                bVar.f14868b[i10] = Long.parseLong(strArrSplit[i10]);
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
            }
        }
    }

    public final synchronized void h0() {
        try {
            BufferedWriter bufferedWriter = this.C;
            if (bufferedWriter != null) {
                d(bufferedWriter);
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f14875w), f.f14885a));
            try {
                bufferedWriter2.write("libcore.io.DiskLruCache");
                bufferedWriter2.write("\n");
                bufferedWriter2.write("1");
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.f14877y));
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.A));
                bufferedWriter2.write("\n");
                bufferedWriter2.write("\n");
                for (b bVar : this.D.values()) {
                    if (bVar.f != null) {
                        bufferedWriter2.write("DIRTY " + bVar.f14867a + '\n');
                    } else {
                        bufferedWriter2.write("CLEAN " + bVar.f14867a + bVar.a() + '\n');
                    }
                }
                d(bufferedWriter2);
                if (this.f14874v.exists()) {
                    i0(this.f14874v, this.f14876x, true);
                }
                i0(this.f14875w, this.f14874v, false);
                this.f14876x.delete();
                this.C = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f14874v, true), f.f14885a));
            } catch (Throwable th) {
                d(bufferedWriter2);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void j0() {
        while (this.B > this.f14878z) {
            String str = (String) ((Map.Entry) this.D.entrySet().iterator().next()).getKey();
            synchronized (this) {
                try {
                    if (this.C == null) {
                        throw new IllegalStateException("cache is closed");
                    }
                    b bVar = (b) this.D.get(str);
                    if (bVar != null && bVar.f == null) {
                        for (int i = 0; i < this.A; i++) {
                            File file = bVar.f14869c[i];
                            if (file.exists() && !file.delete()) {
                                throw new IOException("failed to delete " + file);
                            }
                            long j5 = this.B;
                            long[] jArr = bVar.f14868b;
                            this.B = j5 - jArr[i];
                            jArr[i] = 0;
                        }
                        this.E++;
                        this.C.append((CharSequence) "REMOVE");
                        this.C.append(' ');
                        this.C.append((CharSequence) str);
                        this.C.append('\n');
                        this.D.remove(str);
                        if (H()) {
                            this.G.submit(this.H);
                        }
                    }
                } finally {
                }
            }
        }
    }

    public final a2.c x(String str) {
        synchronized (this) {
            try {
                if (this.C == null) {
                    throw new IllegalStateException("cache is closed");
                }
                b bVar = (b) this.D.get(str);
                if (bVar == null) {
                    bVar = new b(this, str);
                    this.D.put(str, bVar);
                } else if (bVar.f != null) {
                    return null;
                }
                a2.c cVar = new a2.c(this, bVar);
                bVar.f = cVar;
                this.C.append((CharSequence) "DIRTY");
                this.C.append(' ');
                this.C.append((CharSequence) str);
                this.C.append('\n');
                F(this.C);
                return cVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
