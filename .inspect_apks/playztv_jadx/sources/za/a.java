package za;

import android.util.Log;
import b7.s;
import c4.d;
import e6.j;
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
import ta.g;
import ta.i;
import wa.j2;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f14926e = Charset.forName("UTF-8");
    public static final int f = 15;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final xa.a f14927g = new xa.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d f14928h = new d(22);
    public static final g i = new g(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f14929a = new AtomicInteger(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f14930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f14931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f14932d;

    public a(c cVar, s sVar, i iVar) {
        this.f14930b = cVar;
        this.f14931c = sVar;
        this.f14932d = iVar;
    }

    public static void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    public static String e(File file) {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int i10 = fileInputStream.read(bArr);
                if (i10 <= 0) {
                    String str = new String(byteArrayOutputStream.toByteArray(), f14926e);
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

    public static void f(File file, String str) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f14926e);
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
        c cVar = this.f14930b;
        arrayList.addAll(c.e(((File) cVar.f).listFiles()));
        arrayList.addAll(c.e(((File) cVar.f14939g).listFiles()));
        d dVar = f14928h;
        Collections.sort(arrayList, dVar);
        List listE = c.e(((File) cVar.f14938e).listFiles());
        Collections.sort(listE, dVar);
        arrayList.addAll(listE);
        return arrayList;
    }

    public final NavigableSet c() {
        return new TreeSet(c.e(((File) this.f14930b.f14937d).list())).descendingSet();
    }

    public final void d(j2 j2Var, String str, boolean z2) {
        c cVar = this.f14930b;
        int i10 = this.f14931c.d().f1980a.f1942u;
        f14927g.getClass();
        try {
            f(cVar.b(str, j.n("event", String.format(Locale.US, "%010d", Integer.valueOf(this.f14929a.getAndIncrement())), z2 ? "_" : "")), xa.a.f14333a.I(j2Var));
        } catch (IOException e10) {
            Log.w("FirebaseCrashlytics", "Could not persist event for session " + str, e10);
        }
        g gVar = new g(3);
        cVar.getClass();
        File file = new File((File) cVar.f14937d, str);
        file.mkdirs();
        List<File> listE = c.e(file.listFiles(gVar));
        Collections.sort(listE, new d(23));
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
