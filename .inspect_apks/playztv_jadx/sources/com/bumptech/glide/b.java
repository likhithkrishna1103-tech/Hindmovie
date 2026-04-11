package com.bumptech.glide;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule;
import e6.n;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import k8.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ComponentCallbacks2 {
    public static volatile b B;
    public static volatile boolean C;
    public final ArrayList A = new ArrayList();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f6.a f2760u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g6.d f2761v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final e f2762w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f6.f f2763x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.bumptech.glide.manager.k f2764y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final q9.e f2765z;

    public b(Context context, n nVar, g6.d dVar, f6.a aVar, f6.f fVar, com.bumptech.glide.manager.k kVar, q9.e eVar, int i, t7.j jVar, s.e eVar2, List list, List list2, c cVar, wb.c cVar2) {
        this.f2760u = aVar;
        this.f2763x = fVar;
        this.f2761v = dVar;
        this.f2764y = kVar;
        this.f2765z = eVar;
        this.f2762w = new e(context, fVar, new a2.c(this, list2, cVar), new b0(29), jVar, eVar2, list, nVar, cVar2, i);
    }

    public static b a(Context context) {
        GeneratedAppGlideModule generatedAppGlideModule;
        if (B == null) {
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable("Glide", 5)) {
                    Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
                generatedAppGlideModule = null;
            } catch (IllegalAccessException e10) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e10);
            } catch (InstantiationException e11) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e11);
            } catch (NoSuchMethodException e12) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e12);
            } catch (InvocationTargetException e13) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e13);
            }
            synchronized (b.class) {
                if (B == null) {
                    if (C) {
                        throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
                    }
                    C = true;
                    try {
                        b(context, generatedAppGlideModule);
                        C = false;
                    } catch (Throwable th) {
                        C = false;
                        throw th;
                    }
                }
            }
        }
        return B;
    }

    public static void b(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        List list;
        h6.d dVar;
        t7.j jVar;
        s.e eVar = new s.e(0);
        u5.d dVar2 = new u5.d(7);
        t7.j jVar2 = new t7.j(6);
        Context applicationContext = context.getApplicationContext();
        List list2 = Collections.EMPTY_LIST;
        if (generatedAppGlideModule == null || generatedAppGlideModule.n()) {
            if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Loading Glide modules");
            }
            ArrayList arrayList = new ArrayList();
            try {
                ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    if (Log.isLoggable("ManifestParser", 2)) {
                        Log.v("ManifestParser", "Got app info metadata: " + applicationInfo.metaData);
                    }
                    for (String str : applicationInfo.metaData.keySet()) {
                        if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                            arrayList.add(d.C(str));
                            if (Log.isLoggable("ManifestParser", 3)) {
                                Log.d("ManifestParser", "Loaded Glide module: " + str);
                            }
                        }
                    }
                    if (Log.isLoggable("ManifestParser", 3)) {
                        Log.d("ManifestParser", "Finished loading Glide modules");
                    }
                } else if (Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Got null app info metadata");
                }
            } catch (PackageManager.NameNotFoundException e10) {
                if (Log.isLoggable("ManifestParser", 6)) {
                    Log.e("ManifestParser", "Failed to parse glide modules", e10);
                }
            }
            list = arrayList;
        } else {
            list = list2;
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.y().isEmpty()) {
            Set setY = generatedAppGlideModule.y();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                OkHttpGlideModule okHttpGlideModule = (OkHttpGlideModule) it.next();
                if (setY.contains(okHttpGlideModule.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + okHttpGlideModule);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + ((OkHttpGlideModule) it2.next()).getClass());
            }
        }
        q9.e eVarZ = generatedAppGlideModule != null ? generatedAppGlideModule.z() : null;
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            ((OkHttpGlideModule) it3.next()).getClass();
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a();
        }
        h6.a aVar = new h6.a();
        if (h6.d.f5954w == 0) {
            h6.d.f5954w = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        int i = h6.d.f5954w;
        if (TextUtils.isEmpty("source")) {
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: source");
        }
        h6.d dVar3 = new h6.d(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new h6.b(aVar, "source", false)));
        int i10 = h6.d.f5954w;
        h6.a aVar2 = new h6.a();
        if (TextUtils.isEmpty("disk-cache")) {
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: disk-cache");
        }
        h6.d dVar4 = new h6.d(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new h6.b(aVar2, "disk-cache", true)));
        if (h6.d.f5954w == 0) {
            h6.d.f5954w = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        int i11 = h6.d.f5954w >= 4 ? 2 : 1;
        h6.a aVar3 = new h6.a();
        if (TextUtils.isEmpty("animation")) {
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: animation");
        }
        h6.d dVar5 = new h6.d(new ThreadPoolExecutor(i11, i11, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new h6.b(aVar3, "animation", true)));
        g6.e eVar2 = new g6.e(applicationContext);
        b8.d dVar6 = new b8.d();
        Context context2 = eVar2.f5324a;
        float f = eVar2.f5327d;
        ActivityManager activityManager = eVar2.f5325b;
        int i12 = activityManager.isLowRamDevice() ? 2097152 : 4194304;
        dVar6.f1924c = i12;
        int iRound = Math.round(activityManager.getMemoryClass() * 1048576 * (activityManager.isLowRamDevice() ? 0.33f : 0.4f));
        DisplayMetrics displayMetrics = (DisplayMetrics) eVar2.f5326c.f12784v;
        float f4 = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
        int iRound2 = Math.round(f4 * f);
        int iRound3 = Math.round(f4 * 2.0f);
        int i13 = iRound - i12;
        int i14 = iRound3 + iRound2;
        if (i14 <= i13) {
            dVar6.f1923b = iRound3;
            dVar6.f1922a = iRound2;
        } else {
            float f10 = i13 / (f + 2.0f);
            dVar6.f1923b = Math.round(2.0f * f10);
            dVar6.f1922a = Math.round(f10 * f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb2 = new StringBuilder("Calculation complete, Calculated memory cache size: ");
            dVar = dVar5;
            jVar = jVar2;
            sb2.append(Formatter.formatFileSize(context2, dVar6.f1923b));
            sb2.append(", pool size: ");
            sb2.append(Formatter.formatFileSize(context2, dVar6.f1922a));
            sb2.append(", byte array size: ");
            sb2.append(Formatter.formatFileSize(context2, i12));
            sb2.append(", memory class limited? ");
            sb2.append(i14 > iRound);
            sb2.append(", max size: ");
            sb2.append(Formatter.formatFileSize(context2, iRound));
            sb2.append(", memoryClass: ");
            sb2.append(activityManager.getMemoryClass());
            sb2.append(", isLowMemoryDevice: ");
            sb2.append(activityManager.isLowRamDevice());
            Log.d("MemorySizeCalculator", sb2.toString());
        } else {
            dVar = dVar5;
            jVar = jVar2;
        }
        q9.e eVar3 = new q9.e(7);
        int i15 = dVar6.f1922a;
        f6.a gVar = i15 > 0 ? new f6.g(i15) : new t7.j(10);
        f6.f fVar = new f6.f(dVar6.f1924c);
        g6.d dVar7 = new g6.d(dVar6.f1923b);
        b bVar = new b(applicationContext, new n(dVar7, new u5.c(applicationContext, 15), dVar4, dVar3, new h6.d(new ThreadPoolExecutor(0, Integer.MAX_VALUE, h6.d.f5953v, TimeUnit.MILLISECONDS, new SynchronousQueue(), new h6.b(new h6.a(), "source-unlimited", false))), dVar), dVar7, gVar, fVar, new com.bumptech.glide.manager.k(eVarZ), eVar3, 4, jVar, eVar, Collections.EMPTY_LIST, list, generatedAppGlideModule, new wb.c(dVar2));
        applicationContext.registerComponentCallbacks(bVar);
        B = bVar;
    }

    public final void c(m mVar) {
        synchronized (this.A) {
            try {
                if (!this.A.contains(mVar)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.A.remove(mVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        x6.m.a();
        this.f2761v.f(0L);
        this.f2760u.m();
        this.f2763x.a();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        x6.m.a();
        synchronized (this.A) {
            try {
                ArrayList arrayList = this.A;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((m) obj).getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f2761v.g(i);
        this.f2760u.j(i);
        this.f2763x.i(i);
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }
}
