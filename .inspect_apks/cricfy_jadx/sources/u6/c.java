package u6;

import android.os.Build;
import android.os.StrictMode;
import com.bumptech.glide.l;
import f9.k1;
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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Closeable {
    public final long A;
    public BufferedWriter D;
    public int F;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final File f12264v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final File f12265w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final File f12266x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final File f12267y;
    public long C = 0;
    public final LinkedHashMap E = new LinkedHashMap(0, 0.75f, true);
    public long G = 0;
    public final ThreadPoolExecutor H = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a());
    public final k1 I = new k1(2, this);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f12268z = 1;
    public final int B = 1;

    public c(File file, long j4) {
        this.f12264v = file;
        this.f12265w = new File(file, "journal");
        this.f12266x = new File(file, "journal.tmp");
        this.f12267y = new File(file, "journal.bkp");
        this.A = j4;
    }

    public static c J(File file, long j4) throws IOException {
        if (j4 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                g0(file2, file3, false);
            }
        }
        c cVar = new c(file, j4);
        if (cVar.f12265w.exists()) {
            try {
                cVar.Q();
                cVar.O();
                return cVar;
            } catch (IOException e9) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e9.getMessage() + ", removing");
                cVar.close();
                f.a(cVar.f12264v);
            }
        }
        file.mkdirs();
        c cVar2 = new c(file, j4);
        cVar2.e0();
        return cVar2;
    }

    public static void a(c cVar, l lVar, boolean z10) {
        synchronized (cVar) {
            b bVar = (b) lVar.f2223w;
            if (bVar.f != lVar) {
                throw new IllegalStateException();
            }
            if (z10 && !bVar.f12262e) {
                for (int i = 0; i < cVar.B; i++) {
                    if (!((boolean[]) lVar.f2224x)[i]) {
                        lVar.c();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!bVar.f12261d[i].exists()) {
                        lVar.c();
                        return;
                    }
                }
            }
            for (int i10 = 0; i10 < cVar.B; i10++) {
                File file = bVar.f12261d[i10];
                if (!z10) {
                    q(file);
                } else if (file.exists()) {
                    File file2 = bVar.f12260c[i10];
                    file.renameTo(file2);
                    long j4 = bVar.f12259b[i10];
                    long length = file2.length();
                    bVar.f12259b[i10] = length;
                    cVar.C = (cVar.C - j4) + length;
                }
            }
            cVar.F++;
            bVar.f = null;
            if (bVar.f12262e || z10) {
                bVar.f12262e = true;
                cVar.D.append((CharSequence) "CLEAN");
                cVar.D.append(' ');
                cVar.D.append((CharSequence) bVar.f12258a);
                cVar.D.append((CharSequence) bVar.a());
                cVar.D.append('\n');
                if (z10) {
                    cVar.G++;
                }
            } else {
                cVar.E.remove(bVar.f12258a);
                cVar.D.append((CharSequence) "REMOVE");
                cVar.D.append(' ');
                cVar.D.append((CharSequence) bVar.f12258a);
                cVar.D.append('\n');
            }
            z(cVar.D);
            if (cVar.C > cVar.A || cVar.C()) {
                cVar.H.submit(cVar.I);
            }
        }
    }

    public static void g(BufferedWriter bufferedWriter) throws IOException {
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

    public static void g0(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            q(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void q(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void z(BufferedWriter bufferedWriter) throws IOException {
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

    public final synchronized m2.e A(String str) {
        if (this.D == null) {
            throw new IllegalStateException("cache is closed");
        }
        b bVar = (b) this.E.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.f12262e) {
            return null;
        }
        for (File file : bVar.f12260c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.F++;
        this.D.append((CharSequence) "READ");
        this.D.append(' ');
        this.D.append((CharSequence) str);
        this.D.append('\n');
        if (C()) {
            this.H.submit(this.I);
        }
        return new m2.e(bVar.f12260c);
    }

    public final boolean C() {
        int i = this.F;
        return i >= 2000 && i >= this.E.size();
    }

    public final void O() throws IOException {
        q(this.f12266x);
        Iterator it = this.E.values().iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            l lVar = bVar.f;
            int i = this.B;
            int i10 = 0;
            if (lVar == null) {
                while (i10 < i) {
                    this.C += bVar.f12259b[i10];
                    i10++;
                }
            } else {
                bVar.f = null;
                while (i10 < i) {
                    q(bVar.f12260c[i10]);
                    q(bVar.f12261d[i10]);
                    i10++;
                }
                it.remove();
            }
        }
    }

    public final void Q() {
        File file = this.f12265w;
        e eVar = new e(new FileInputStream(file), f.f12275a);
        try {
            String strA = eVar.a();
            String strA2 = eVar.a();
            String strA3 = eVar.a();
            String strA4 = eVar.a();
            String strA5 = eVar.a();
            if (!"libcore.io.DiskLruCache".equals(strA) || !"1".equals(strA2) || !Integer.toString(this.f12268z).equals(strA3) || !Integer.toString(this.B).equals(strA4) || !"".equals(strA5)) {
                throw new IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    R(eVar.a());
                    i++;
                } catch (EOFException unused) {
                    this.F = i - this.E.size();
                    if (eVar.f12274z == -1) {
                        e0();
                    } else {
                        this.D = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), f.f12275a));
                    }
                    try {
                        eVar.close();
                        return;
                    } catch (RuntimeException e9) {
                        throw e9;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                eVar.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final void R(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        LinkedHashMap linkedHashMap = this.E;
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
                bVar.f = new l(this, bVar);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
        bVar.f12262e = true;
        bVar.f = null;
        if (strArrSplit.length != bVar.f12263g.B) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
        }
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            try {
                bVar.f12259b[i10] = Long.parseLong(strArrSplit[i10]);
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.D == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.E.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                l lVar = ((b) obj).f;
                if (lVar != null) {
                    lVar.c();
                }
            }
            h0();
            g(this.D);
            this.D = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void e0() {
        try {
            BufferedWriter bufferedWriter = this.D;
            if (bufferedWriter != null) {
                g(bufferedWriter);
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f12266x), f.f12275a));
            try {
                bufferedWriter2.write("libcore.io.DiskLruCache");
                bufferedWriter2.write("\n");
                bufferedWriter2.write("1");
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.f12268z));
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.B));
                bufferedWriter2.write("\n");
                bufferedWriter2.write("\n");
                for (b bVar : this.E.values()) {
                    if (bVar.f != null) {
                        bufferedWriter2.write("DIRTY " + bVar.f12258a + '\n');
                    } else {
                        bufferedWriter2.write("CLEAN " + bVar.f12258a + bVar.a() + '\n');
                    }
                }
                g(bufferedWriter2);
                if (this.f12265w.exists()) {
                    g0(this.f12265w, this.f12267y, true);
                }
                g0(this.f12266x, this.f12265w, false);
                this.f12267y.delete();
                this.D = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f12265w, true), f.f12275a));
            } catch (Throwable th) {
                g(bufferedWriter2);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void h0() {
        while (this.C > this.A) {
            String str = (String) ((Map.Entry) this.E.entrySet().iterator().next()).getKey();
            synchronized (this) {
                try {
                    if (this.D == null) {
                        throw new IllegalStateException("cache is closed");
                    }
                    b bVar = (b) this.E.get(str);
                    if (bVar != null && bVar.f == null) {
                        for (int i = 0; i < this.B; i++) {
                            File file = bVar.f12260c[i];
                            if (file.exists() && !file.delete()) {
                                throw new IOException("failed to delete " + file);
                            }
                            long j4 = this.C;
                            long[] jArr = bVar.f12259b;
                            this.C = j4 - jArr[i];
                            jArr[i] = 0;
                        }
                        this.F++;
                        this.D.append((CharSequence) "REMOVE");
                        this.D.append(' ');
                        this.D.append((CharSequence) str);
                        this.D.append('\n');
                        this.E.remove(str);
                        if (C()) {
                            this.H.submit(this.I);
                        }
                    }
                } finally {
                }
            }
        }
    }

    public final l s(String str) {
        synchronized (this) {
            try {
                if (this.D == null) {
                    throw new IllegalStateException("cache is closed");
                }
                b bVar = (b) this.E.get(str);
                if (bVar == null) {
                    bVar = new b(this, str);
                    this.E.put(str, bVar);
                } else if (bVar.f != null) {
                    return null;
                }
                l lVar = new l(this, bVar);
                bVar.f = lVar;
                this.D.append((CharSequence) "DIRTY");
                this.D.append(' ');
                this.D.append((CharSequence) str);
                this.D.append('\n');
                z(this.D);
                return lVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
