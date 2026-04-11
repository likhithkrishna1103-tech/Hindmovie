package tb;

import android.util.Log;
import d8.j;
import g4.d;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import l0.e;
import nb.g;
import nb.i;
import qb.j2;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f11975e = Charset.forName("UTF-8");
    public static final int f = 15;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final rb.a f11976g = new rb.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f11977h = new d(9);
    public static final g i = new g(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f11978a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f11979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f11980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f11981d;

    public a(c cVar, j jVar, i iVar) {
        this.f11979b = cVar;
        this.f11980c = jVar;
        this.f11981d = iVar;
    }

    public static void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public static String e(File file) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i10 = fileInputStream.read(bArr);
                if (i10 <= 0) {
                    String str = new String(byteArrayOutputStream.toByteArray(), f11975e);
                    fileInputStream.close();
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public static void f(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f11975e);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
        } catch (Throwable th) {
            try {
                outputStreamWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        c cVar = this.f11979b;
        arrayList.addAll(c.e(((File) cVar.A).listFiles()));
        arrayList.addAll(c.e(((File) cVar.B).listFiles()));
        d dVar = f11977h;
        Collections.sort(arrayList, dVar);
        List listE = c.e(((File) cVar.f11987z).listFiles());
        Collections.sort(listE, dVar);
        arrayList.addAll(listE);
        return arrayList;
    }

    public final NavigableSet c() {
        return new TreeSet(c.e(((File) this.f11979b.f11986y).list())).descendingSet();
    }

    public final void d(j2 j2Var, String str, boolean z10) {
        c cVar = this.f11979b;
        int i10 = this.f11980c.d().f13545a.f10418v;
        f11976g.getClass();
        try {
            f(cVar.b(str, e.k("event", String.format(Locale.US, "%010d", Integer.valueOf(this.f11978a.getAndIncrement())), z10 ? "_" : "")), rb.a.f10920a.g(j2Var));
        } catch (IOException e9) {
            Log.w("FirebaseCrashlytics", "Could not persist event for session " + str, e9);
        }
        g gVar = new g(3);
        cVar.getClass();
        File file = new File((File) cVar.f11986y, str);
        file.mkdirs();
        List<File> listE = c.e(file.listFiles(gVar));
        Collections.sort(listE, new d(10));
        int size = listE.size();
        for (File file2 : listE) {
            if (size <= i10) {
                return;
            }
            c.d(file2);
            size--;
        }
    }
}
