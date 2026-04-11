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
import f9.a0;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import w4.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements ComponentCallbacks2 {
    public static volatile b C;
    public static volatile boolean D;
    public final ka.f A;
    public final ArrayList B = new ArrayList();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a7.b f2193v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b7.f f2194w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final g f2195x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a7.g f2196y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.bumptech.glide.manager.l f2197z;

    public b(Context context, z6.n nVar, b7.f fVar, a7.b bVar, a7.g gVar, com.bumptech.glide.manager.l lVar, ka.f fVar2, int i, o8.j jVar, v.e eVar, List list, List list2, v vVar, pc.c cVar) {
        this.f2193v = bVar;
        this.f2196y = gVar;
        this.f2194w = fVar;
        this.f2197z = lVar;
        this.A = fVar2;
        this.f2195x = new g(context, gVar, new l(this, list2, vVar), new a0(21), jVar, eVar, list, nVar, cVar, i);
    }

    public static b a(Context context) {
        GeneratedAppGlideModule generatedAppGlideModule;
        if (C == null) {
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable("Glide", 5)) {
                    Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
                generatedAppGlideModule = null;
            } catch (IllegalAccessException e9) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e9);
            } catch (InstantiationException e10) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e10);
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e11);
            } catch (InvocationTargetException e12) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e12);
            }
            synchronized (b.class) {
                if (C == null) {
                    if (D) {
                        throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
                    }
                    D = true;
                    try {
                        b(context, generatedAppGlideModule);
                        D = false;
                    } catch (Throwable th) {
                        D = false;
                        throw th;
                    }
                }
            }
        }
        return C;
    }

    public static void b(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        List list;
        c7.d dVar;
        o8.j jVar;
        v.e eVar = new v.e(0);
        p6.d dVar2 = new p6.d(4);
        o8.j jVar2 = new o8.j(7);
        Context applicationContext = context.getApplicationContext();
        List list2 = Collections.EMPTY_LIST;
        if (generatedAppGlideModule == null || generatedAppGlideModule.m()) {
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
                            arrayList.add(w8.e.j(str));
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
            } catch (PackageManager.NameNotFoundException e9) {
                if (Log.isLoggable("ManifestParser", 6)) {
                    Log.e("ManifestParser", "Failed to parse glide modules", e9);
                }
            }
            list = arrayList;
        } else {
            list = list2;
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.z().isEmpty()) {
            Set setZ = generatedAppGlideModule.z();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                OkHttpGlideModule okHttpGlideModule = (OkHttpGlideModule) it.next();
                if (setZ.contains(okHttpGlideModule.getClass())) {
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
        com.bumptech.glide.manager.k kVarA = generatedAppGlideModule != null ? generatedAppGlideModule.A() : null;
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            ((OkHttpGlideModule) it3.next()).getClass();
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.d();
        }
        c7.a aVar = new c7.a();
        if (c7.d.f2107x == 0) {
            c7.d.f2107x = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        int i = c7.d.f2107x;
        if (TextUtils.isEmpty("source")) {
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: source");
        }
        c7.d dVar3 = new c7.d(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new c7.b(aVar, "source", false)));
        int i10 = c7.d.f2107x;
        c7.a aVar2 = new c7.a();
        if (TextUtils.isEmpty("disk-cache")) {
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: disk-cache");
        }
        c7.d dVar4 = new c7.d(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new c7.b(aVar2, "disk-cache", true)));
        if (c7.d.f2107x == 0) {
            c7.d.f2107x = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        int i11 = c7.d.f2107x >= 4 ? 2 : 1;
        c7.a aVar3 = new c7.a();
        if (TextUtils.isEmpty("animation")) {
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: animation");
        }
        c7.d dVar5 = new c7.d(new ThreadPoolExecutor(i11, i11, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new c7.b(aVar3, "animation", true)));
        b7.g gVar = new b7.g(applicationContext);
        a3.d dVar6 = new a3.d();
        Context context2 = gVar.f1833a;
        float f = gVar.f1836d;
        ActivityManager activityManager = gVar.f1834b;
        int i12 = activityManager.isLowRamDevice() ? 2097152 : 4194304;
        dVar6.f156c = i12;
        int iRound = Math.round(activityManager.getMemoryClass() * 1048576 * (activityManager.isLowRamDevice() ? 0.33f : 0.4f));
        DisplayMetrics displayMetrics = (DisplayMetrics) gVar.f1835c.f10037w;
        float f10 = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
        int iRound2 = Math.round(f10 * f);
        int iRound3 = Math.round(f10 * 2.0f);
        int i13 = iRound - i12;
        int i14 = iRound3 + iRound2;
        if (i14 <= i13) {
            dVar6.f155b = iRound3;
            dVar6.f154a = iRound2;
        } else {
            float f11 = i13 / (f + 2.0f);
            dVar6.f155b = Math.round(2.0f * f11);
            dVar6.f154a = Math.round(f11 * f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder("Calculation complete, Calculated memory cache size: ");
            dVar = dVar4;
            jVar = jVar2;
            sb.append(Formatter.formatFileSize(context2, dVar6.f155b));
            sb.append(", pool size: ");
            sb.append(Formatter.formatFileSize(context2, dVar6.f154a));
            sb.append(", byte array size: ");
            sb.append(Formatter.formatFileSize(context2, i12));
            sb.append(", memory class limited? ");
            sb.append(i14 > iRound);
            sb.append(", max size: ");
            sb.append(Formatter.formatFileSize(context2, iRound));
            sb.append(", memoryClass: ");
            sb.append(activityManager.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(activityManager.isLowRamDevice());
            Log.d("MemorySizeCalculator", sb.toString());
        } else {
            dVar = dVar4;
            jVar = jVar2;
        }
        ka.f fVar = new ka.f(8);
        int i15 = dVar6.f154a;
        a7.b iVar = i15 > 0 ? new a7.i(i15) : new o8.j(1);
        a7.g gVar2 = new a7.g(dVar6.f156c);
        c7.d dVar7 = dVar;
        b7.f fVar2 = new b7.f(dVar6.f155b);
        z6.n nVar = new z6.n(fVar2, new p6.c(applicationContext), dVar7, dVar3, new c7.d(new ThreadPoolExecutor(0, Integer.MAX_VALUE, c7.d.f2106w, TimeUnit.MILLISECONDS, new SynchronousQueue(), new c7.b(new c7.a(), "source-unlimited", false))), dVar5);
        List list3 = Collections.EMPTY_LIST;
        pc.c cVar = new pc.c();
        cVar.f10180v = Collections.unmodifiableMap(new HashMap((HashMap) dVar2.f10037w));
        b bVar = new b(applicationContext, nVar, fVar2, iVar, gVar2, new com.bumptech.glide.manager.l(kVarA), fVar, 4, jVar, eVar, list3, list, generatedAppGlideModule, cVar);
        applicationContext.registerComponentCallbacks(bVar);
        C = bVar;
    }

    public static p d(Context context) {
        s7.f.c(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).f2197z.b(context);
    }

    public final void c(p pVar) {
        synchronized (this.B) {
            try {
                if (!this.B.contains(pVar)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.B.remove(pVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        s7.m.a();
        this.f2194w.f(0L);
        this.f2193v.g();
        this.f2196y.a();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        s7.m.a();
        synchronized (this.B) {
            try {
                ArrayList arrayList = this.B;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((p) obj).getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f2194w.g(i);
        this.f2193v.e(i);
        this.f2196y.i(i);
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }
}
