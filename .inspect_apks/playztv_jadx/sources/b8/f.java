package b8;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final lb.e f1925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final pa.b f1926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f1927d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f1928e = null;
    public static boolean f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f1929g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Boolean f1930h;
    public static final ThreadLocal i = new ThreadLocal();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final j f1931j = new j(0);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final t7.j f1932k = new t7.j(3);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static m f1933l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static n f1934m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1935a;

    static {
        int i10 = 4;
        f1925b = new lb.e(i10);
        f1926c = new pa.b(i10);
    }

    public f(Context context) {
        this.f1935a = context;
    }

    public static int a(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (v.k(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e10) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e10.getMessage())));
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0091 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #3 {all -> 0x0085, blocks: (B:7:0x004b, B:11:0x007f, B:18:0x008b, B:21:0x0091, B:24:0x00a5, B:102:0x020d, B:103:0x0214, B:106:0x0217, B:107:0x0218, B:108:0x021f, B:125:0x027f, B:126:0x0290, B:109:0x0220, B:111:0x023e, B:113:0x024b, B:123:0x0277, B:124:0x027e, B:127:0x0291, B:128:0x02bd), top: B:146:0x004b, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b8.f c(android.content.Context r22, b8.e r23, java.lang.String r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 741
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.f.c(android.content.Context, b8.e, java.lang.String):b8.f");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0182 A[Catch: all -> 0x00ec, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x00ec, blocks: (B:3:0x0002, B:63:0x00e1, B:65:0x00e7, B:73:0x010d, B:103:0x0182, B:111:0x0197, B:129:0x0219, B:130:0x021c, B:124:0x0210, B:71:0x00f2, B:132:0x021e, B:4:0x0003, B:7:0x000a, B:8:0x0026, B:61:0x00de, B:21:0x004a, B:44:0x00a1, B:47:0x00a4, B:54:0x00bc, B:62:0x00e0, B:60:0x00c2), top: B:145:0x0002, inners: #7, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b0 A[Catch: all -> 0x0037, TryCatch #12 {, blocks: (B:9:0x0027, B:11:0x0033, B:51:0x00b9, B:16:0x003c, B:18:0x0043, B:20:0x0049, B:25:0x0050, B:27:0x0054, B:30:0x005d, B:32:0x0065, B:35:0x006c, B:42:0x0098, B:43:0x00a0, B:38:0x0073, B:40:0x0079, B:41:0x008a, B:46:0x00a3, B:49:0x00a6, B:50:0x00b0, B:17:0x003f), top: B:149:0x0027, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int d(android.content.Context r11, java.lang.String r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b8.f.d(android.content.Context, java.lang.String, boolean):int");
    }

    public static int e(Context context, String str, boolean z2, boolean z10) throws Throwable {
        Throwable th;
        Exception exc;
        boolean z11;
        Cursor cursorQuery;
        boolean z12;
        try {
            try {
                z11 = true;
                cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z2 ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(((Long) f1931j.get()).longValue())).build(), null, null, null, null);
            } catch (Exception e10) {
                exc = e10;
            }
            if (cursorQuery != null) {
                try {
                } catch (Exception e11) {
                    exc = e11;
                } catch (Throwable th2) {
                    cursor = cursorQuery;
                    th = th2;
                    if (cursor == null) {
                        throw th;
                    }
                    cursor.close();
                    throw th;
                }
                if (cursorQuery.moveToFirst()) {
                    boolean z13 = false;
                    int i10 = cursorQuery.getInt(0);
                    if (i10 > 0) {
                        synchronized (f.class) {
                            try {
                                f1928e = cursorQuery.getString(2);
                                int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                if (columnIndex >= 0) {
                                    f1929g = cursorQuery.getInt(columnIndex);
                                }
                                int columnIndex2 = cursorQuery.getColumnIndex("disableStandaloneDynamiteLoader2");
                                if (columnIndex2 >= 0) {
                                    z12 = cursorQuery.getInt(columnIndex2) != 0;
                                    f = z12;
                                } else {
                                    z12 = false;
                                }
                            } catch (Throwable th3) {
                                throw th3;
                            }
                        }
                        k kVar = (k) i.get();
                        if (kVar == null || kVar.f1941a != null) {
                            z11 = false;
                        } else {
                            kVar.f1941a = cursorQuery;
                        }
                        cursor = z11 ? null : cursorQuery;
                        z13 = z12;
                    } else {
                        cursor = cursorQuery;
                    }
                    if (z10 && z13) {
                        throw new b("forcing fallback to container DynamiteLoader impl");
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return i10;
                    if (exc instanceof b) {
                        throw exc;
                    }
                    throw new b("V2 version check failed: " + exc.getMessage(), exc);
                }
            }
            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
            throw new b("Failed to connect to dynamite module ContentResolver.");
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static void f(ClassLoader classLoader) throws b {
        try {
            n nVar = null;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder != null) {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                nVar = iInterfaceQueryLocalInterface instanceof n ? (n) iInterfaceQueryLocalInterface : new n(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2", 1);
            }
            f1934m = nVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            throw new b("Failed to instantiate dynamite loader", e10);
        }
    }

    public static boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f1930h)) {
            return true;
        }
        boolean z2 = false;
        if (f1930h == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (q7.f.f11040b.b(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z2 = true;
            }
            f1930h = Boolean.valueOf(z2);
            if (z2 && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f = true;
            }
        }
        if (!z2) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z2;
    }

    public static m h(Context context) {
        m mVar;
        synchronized (f.class) {
            m mVar2 = f1933l;
            if (mVar2 != null) {
                return mVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    mVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    mVar = iInterfaceQueryLocalInterface instanceof m ? (m) iInterfaceQueryLocalInterface : new m(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader", 1);
                }
                if (mVar != null) {
                    f1933l = mVar;
                    return mVar;
                }
            } catch (Exception e10) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e10.getMessage());
            }
            return null;
        }
    }

    public final IBinder b(String str) throws b {
        try {
            return (IBinder) this.f1935a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e10) {
            throw new b("Failed to instantiate module class: ".concat(str), e10);
        }
    }
}
