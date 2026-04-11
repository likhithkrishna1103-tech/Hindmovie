package za;

import android.content.Context;
import android.util.Log;
import e6.n;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import ta.f;
import va.d;
import va.h;
import va.o;
import wa.z0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f14934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f14935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f14936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f14937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f14938e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f14939g;

    public c(Context context) {
        String string;
        String str = ((z0) qa.c.f11168b.d(context)).f14078a;
        this.f14934a = str;
        File filesDir = context.getFilesDir();
        this.f14935b = filesDir;
        if (str.isEmpty()) {
            string = ".com.google.firebase.crashlytics.files.v1";
        } else {
            StringBuilder sb2 = new StringBuilder(".crashlytics.v3");
            sb2.append(File.separator);
            sb2.append(str.length() > 40 ? f.h(str) : str.replaceAll("[^a-zA-Z0-9.]", "_"));
            string = sb2.toString();
        }
        File file = new File(filesDir, string);
        c(file);
        this.f14936c = file;
        File file2 = new File(file, "open-sessions");
        c(file2);
        this.f14937d = file2;
        File file3 = new File(file, "reports");
        c(file3);
        this.f14938e = file3;
        File file4 = new File(file, "priority-reports");
        c(file4);
        this.f = file4;
        File file5 = new File(file, "native-reports");
        c(file5);
        this.f14939g = file5;
    }

    public static synchronized void c(File file) {
        try {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return;
                }
                String str = "Unexpected non-directory file: " + file + "; deleting file and creating new directory.";
                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", str, null);
                }
                file.delete();
            }
            if (!file.mkdirs()) {
                Log.e("FirebaseCrashlytics", "Could not create Crashlytics-specific directory: " + file, null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static boolean d(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                d(file2);
            }
        }
        return file.delete();
    }

    public static List e(Object[] objArr) {
        return objArr == null ? Collections.EMPTY_LIST : Arrays.asList(objArr);
    }

    public void a(String str) {
        File file = new File((File) this.f14935b, str);
        if (file.exists() && d(file)) {
            String str2 = "Deleted previous Crashlytics file system: " + file.getPath();
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", str2, null);
            }
        }
    }

    public File b(String str, String str2) {
        File file = new File((File) this.f14937d, str);
        file.mkdirs();
        return new File(file, str2);
    }

    public void f(String str) {
        a2.c cVar = (a2.c) this.f14938e;
        synchronized (cVar) {
            try {
                if (((d) ((AtomicMarkableReference) cVar.f173v).getReference()).b(str)) {
                    AtomicMarkableReference atomicMarkableReference = (AtomicMarkableReference) cVar.f173v;
                    atomicMarkableReference.set((d) atomicMarkableReference.getReference(), true);
                    nc.b bVar = new nc.b(14, cVar);
                    AtomicReference atomicReference = (AtomicReference) cVar.f174w;
                    while (!atomicReference.compareAndSet(null, bVar)) {
                        if (atomicReference.get() != null) {
                            return;
                        }
                    }
                    ((ua.d) ((c) cVar.f175x).f14936c).f12824b.a(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public c(String str, c cVar, ua.d dVar) {
        this.f14937d = new a2.c(this, false);
        this.f14938e = new a2.c(this, true);
        this.f = new o();
        this.f14939g = new AtomicMarkableReference(null, false);
        this.f14934a = str;
        this.f14935b = new h(cVar);
        this.f14936c = dVar;
    }

    public c(h6.d dVar, h6.d dVar2, h6.d dVar3, h6.d dVar4, n nVar, n nVar2) {
        this.f14939g = y6.d.a(150, new rc.b(9, this));
        this.f14934a = dVar;
        this.f14935b = dVar2;
        this.f14936c = dVar3;
        this.f14937d = dVar4;
        this.f14938e = nVar;
        this.f = nVar2;
    }
}
