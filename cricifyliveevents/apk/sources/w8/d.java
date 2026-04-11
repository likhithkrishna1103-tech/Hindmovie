package w8;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import f9.a0;
import f9.b0;
import f9.c0;
import f9.z;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import o8.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f14115e = null;
    public static String f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f14116g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f14117h = -1;
    public static Boolean i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static h f14121m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static i f14122n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14123a;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ThreadLocal f14118j = new ThreadLocal();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ie.b f14119k = new ie.b(6);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b0 f14120l = new b0(28);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c0 f14112b = new c0(28);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final z f14113c = new z(29);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a0 f14114d = new a0(29);

    public d(Context context) {
        this.f14123a = context;
    }

    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(str.length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> clsLoadClass = classLoader.loadClass(sb.toString());
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (u.j(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String strValueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 50 + str.length() + 1);
            sb2.append("Module descriptor id '");
            sb2.append(strValueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(str.length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e9) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e9.getMessage())));
            return 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02fa A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0300 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0309 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c3 A[Catch: all -> 0x00b8, TRY_LEAVE, TryCatch #11 {all -> 0x00b8, blocks: (B:5:0x0042, B:9:0x00b1, B:16:0x00bd, B:19:0x00c3, B:31:0x00ec, B:119:0x0299, B:120:0x02a0, B:128:0x02af, B:130:0x02d7, B:132:0x02e6, B:142:0x0312, B:143:0x0319, B:123:0x02a3, B:124:0x02a4, B:125:0x02ab, B:144:0x031a, B:145:0x033a, B:146:0x033b, B:147:0x0388), top: B:167:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e9  */
    /* JADX WARN: Type inference failed for: r30v0, types: [w8.c] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.content.Context] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static w8.d c(android.content.Context r29, w8.c r30, java.lang.String r31) throws w8.a {
        /*
            Method dump skipped, instruction units count: 941
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.d.c(android.content.Context, w8.c, java.lang.String):w8.d");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0194 A[Catch: all -> 0x00f4, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x00f4, blocks: (B:4:0x0006, B:64:0x00e9, B:66:0x00ef, B:74:0x011d, B:104:0x0194, B:112:0x01a9, B:130:0x0233, B:131:0x0236, B:125:0x022a, B:72:0x00fa, B:133:0x0238, B:5:0x0007, B:8:0x000e, B:9:0x002a, B:62:0x00e6, B:22:0x004e, B:45:0x00a5, B:48:0x00a8, B:55:0x00c0, B:63:0x00e8, B:61:0x00c6), top: B:146:0x0006, inners: #0, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b4 A[Catch: all -> 0x003b, TryCatch #12 {, blocks: (B:10:0x002b, B:12:0x0037, B:52:0x00bd, B:17:0x0040, B:19:0x0047, B:21:0x004d, B:26:0x0054, B:28:0x0058, B:31:0x0061, B:33:0x0069, B:36:0x0070, B:43:0x009c, B:44:0x00a4, B:39:0x0077, B:41:0x007d, B:42:0x008e, B:47:0x00a7, B:50:0x00aa, B:51:0x00b4, B:18:0x0043), top: B:150:0x002b, inners: #13 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int d(android.content.Context r13, java.lang.String r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 583
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.d.d(android.content.Context, java.lang.String, boolean):int");
    }

    public static boolean e(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(i)) {
            return true;
        }
        boolean z10 = false;
        if (i == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", Build.VERSION.SDK_INT >= 29 ? 268435456 : 0);
            if (l8.f.f7890b.b(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z10 = true;
            }
            i = Boolean.valueOf(z10);
            if (z10 && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f14116g = true;
            }
        }
        if (!z10) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z10;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013a A[PHI: r3
      0x013a: PHI (r3v4 boolean) = (r3v3 boolean), (r3v6 boolean) binds: [B:58:0x00f1, B:83:0x0137] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int f(android.content.Context r14, java.lang.String r15, boolean r16, boolean r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.d.f(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    public static void g(ClassLoader classLoader) throws a {
        try {
            i iVar = null;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder != null) {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                iVar = iInterfaceQueryLocalInterface instanceof i ? (i) iInterfaceQueryLocalInterface : new i(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2", 0);
            }
            f14122n = iVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e9) {
            throw new a("Failed to instantiate dynamite loader", e9);
        }
    }

    public static h h(Context context) {
        h hVar;
        synchronized (d.class) {
            h hVar2 = f14121m;
            if (hVar2 != null) {
                return hVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    hVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    hVar = iInterfaceQueryLocalInterface instanceof h ? (h) iInterfaceQueryLocalInterface : new h(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader", 0);
                }
                if (hVar != null) {
                    f14121m = hVar;
                    return hVar;
                }
            } catch (Exception e9) {
                String message = e9.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 45);
                sb.append("Failed to load IDynamiteLoader from GmsCore: ");
                sb.append(message);
                Log.e("DynamiteModule", sb.toString());
            }
            return null;
        }
    }

    public final IBinder b(String str) throws a {
        try {
            return (IBinder) this.f14123a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e9) {
            throw new a("Failed to instantiate module class: ".concat(str), e9);
        }
    }
}
