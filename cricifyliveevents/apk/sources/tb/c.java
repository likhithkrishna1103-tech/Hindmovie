package tb;

import android.content.Context;
import android.util.Log;
import androidx.emoji2.text.v;
import com.bumptech.glide.l;
import d8.j;
import f9.a0;
import f9.b0;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import kf.i;
import nb.f;
import of.t;
import pb.d;
import pb.g;
import qb.z0;
import z6.n;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements z7.b {
    public final Object A;
    public final Object B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f11983v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f11984w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f11985x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f11986y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Object f11987z;

    public /* synthetic */ c(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        this.f11983v = obj;
        this.f11984w = obj2;
        this.f11985x = obj3;
        this.f11986y = obj4;
        this.f11987z = obj5;
        this.A = obj6;
        this.B = obj7;
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
        File file = new File((File) this.f11984w, str);
        if (file.exists() && d(file)) {
            String str2 = "Deleted previous Crashlytics file system: " + file.getPath();
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", str2, null);
            }
        }
    }

    public File b(String str, String str2) {
        File file = new File((File) this.f11986y, str);
        file.mkdirs();
        return new File(file, str2);
    }

    public void f(String str) {
        l lVar = (l) this.f11987z;
        synchronized (lVar) {
            try {
                if (((d) ((AtomicMarkableReference) lVar.f2223w).getReference()).c(str)) {
                    AtomicMarkableReference atomicMarkableReference = (AtomicMarkableReference) lVar.f2223w;
                    atomicMarkableReference.set((d) atomicMarkableReference.getReference(), true);
                    pa.c cVar = new pa.c(3, lVar);
                    AtomicReference atomicReference = (AtomicReference) lVar.f2224x;
                    while (!atomicReference.compareAndSet(null, cVar)) {
                        if (atomicReference.get() != null) {
                            return;
                        }
                    }
                    ((ob.c) ((c) lVar.f2225y).f11985x).f9743b.a(cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // qd.a
    public Object get() {
        Context context = (Context) ((qd.a) this.f11983v).get();
        y7.d dVar = (y7.d) ((qd.a) this.f11984w).get();
        e8.d dVar2 = (e8.d) ((qd.a) this.f11985x).get();
        v vVar = (v) ((v) this.f11986y).get();
        Executor executor = (Executor) ((qd.a) this.f11987z).get();
        f8.c cVar = (f8.c) ((qd.a) this.A).get();
        b0 b0Var = new b0(13);
        a0 a0Var = new a0(13);
        e8.c cVar2 = (e8.c) ((qd.a) this.B).get();
        j jVar = new j();
        jVar.f3551a = context;
        jVar.f3552b = dVar;
        jVar.f3553c = dVar2;
        jVar.f3554d = vVar;
        jVar.f3555e = executor;
        jVar.f = cVar;
        jVar.f3556g = b0Var;
        jVar.f3557h = a0Var;
        jVar.i = cVar2;
        return jVar;
    }

    public c(Context context) {
        String string;
        String str = ((z0) kb.c.f7397b.d(context)).f10781a;
        this.f11983v = str;
        File filesDir = context.getFilesDir();
        this.f11984w = filesDir;
        if (str.isEmpty()) {
            string = ".com.google.firebase.crashlytics.files.v1";
        } else {
            StringBuilder sb = new StringBuilder(".crashlytics.v3");
            sb.append(File.separator);
            sb.append(str.length() > 40 ? f.h(str) : str.replaceAll("[^a-zA-Z0-9.]", "_"));
            string = sb.toString();
        }
        File file = new File(filesDir, string);
        c(file);
        this.f11985x = file;
        File file2 = new File(file, "open-sessions");
        c(file2);
        this.f11986y = file2;
        File file3 = new File(file, "reports");
        c(file3);
        this.f11987z = file3;
        File file4 = new File(file, "priority-reports");
        c(file4);
        this.A = file4;
        File file5 = new File(file, "native-reports");
        c(file5);
        this.B = file5;
    }

    public c(String str, c cVar, ob.c cVar2) {
        this.f11986y = new l(this, false);
        this.f11987z = new l(this, true);
        this.A = new t();
        this.B = new AtomicMarkableReference(null, false);
        this.f11983v = str;
        this.f11984w = new g(cVar);
        this.f11985x = cVar2;
    }

    public c(c7.d dVar, c7.d dVar2, c7.d dVar3, c7.d dVar4, n nVar, n nVar2) {
        this.B = t7.d.a(150, new i(29, this));
        this.f11983v = dVar;
        this.f11984w = dVar2;
        this.f11985x = dVar3;
        this.f11986y = dVar4;
        this.f11987z = nVar;
        this.A = nVar2;
    }
}
