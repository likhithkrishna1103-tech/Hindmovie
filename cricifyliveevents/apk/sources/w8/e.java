package w8;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.Window;
import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule;
import d1.b1;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import pe.a0;
import pe.j;
import pe.q;
import x.k;
import x.l;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ClassLoader f14124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Thread f14125c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14126a;

    public /* synthetic */ e(int i) {
        this.f14126a = i;
    }

    public static void a(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public static void b(SpannableStringBuilder spannableStringBuilder, Object obj, int i, int i10) {
        for (Object obj2 : spannableStringBuilder.getSpans(i, i10, obj.getClass())) {
            if (spannableStringBuilder.getSpanStart(obj2) == i && spannableStringBuilder.getSpanEnd(obj2) == i10 && spannableStringBuilder.getSpanFlags(obj2) == 33) {
                spannableStringBuilder.removeSpan(obj2);
            }
        }
        spannableStringBuilder.setSpan(obj, i, i10, 33);
    }

    public static k c(a0 a0Var) {
        x.i iVar = new x.i();
        iVar.f14203c = new l();
        k kVar = new k(iVar);
        iVar.f14202b = kVar;
        iVar.f14201a = q4.a.class;
        try {
            a0Var.K(true, new j(2, new b1(2, iVar, a0Var)));
            iVar.f14201a = "Deferred.asListenableFuture";
            return kVar;
        } catch (Exception e9) {
            kVar.f14206w.k(e9);
            return kVar;
        }
    }

    public static int d(int i, int i10, int i11) {
        return i < i10 ? i10 : i > i11 ? i11 : i;
    }

    public static Parcelable f(Parcelable parcelable, Parcelable.Creator creator) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            return (Parcelable) creator.createFromParcel(parcelObtain);
        } finally {
            parcelObtain.recycle();
        }
    }

    public static String g(androidx.datastore.preferences.protobuf.g gVar) {
        StringBuilder sb = new StringBuilder(gVar.size());
        for (int i = 0; i < gVar.size(); i++) {
            byte bA = gVar.a(i);
            if (bA == 34) {
                sb.append("\\\"");
            } else if (bA == 39) {
                sb.append("\\'");
            } else if (bA != 92) {
                switch (bA) {
                    case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                        sb.append("\\a");
                        break;
                    case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bA < 32 || bA > 126) {
                            sb.append('\\');
                            sb.append((char) (((bA >>> 6) & 3) + 48));
                            sb.append((char) (((bA >>> 3) & 7) + 48));
                            sb.append((char) ((bA & 7) + 48));
                        } else {
                            sb.append((char) bA);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static vd.f h(vd.f fVar, vd.g gVar) {
        ge.i.e(gVar, "key");
        if (ge.i.a(fVar.getKey(), gVar)) {
            return fVar;
        }
        return null;
    }

    public static vd.h i(vd.f fVar, vd.g gVar) {
        ge.i.e(gVar, "key");
        return ge.i.a(fVar.getKey(), gVar) ? vd.i.f13722v : fVar;
    }

    public static OkHttpGlideModule j(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                if (objNewInstance instanceof OkHttpGlideModule) {
                    return (OkHttpGlideModule) objNewInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + objNewInstance);
            } catch (IllegalAccessException e9) {
                n(cls, e9);
                throw null;
            } catch (InstantiationException e10) {
                n(cls, e10);
                throw null;
            } catch (NoSuchMethodException e11) {
                n(cls, e11);
                throw null;
            } catch (InvocationTargetException e12) {
                n(cls, e12);
                throw null;
            }
        } catch (ClassNotFoundException e13) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e13);
        }
    }

    public static vd.h k(vd.f fVar, vd.h hVar) {
        ge.i.e(hVar, "context");
        return hVar == vd.i.f13722v ? fVar : (vd.h) hVar.J(fVar, new q(8));
    }

    public static void l(Window window, boolean z10) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            m0.a.d(window, z10);
        } else {
            if (i >= 30) {
                m0.a.c(window, z10);
                return;
            }
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z10 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    public static final h1.e m(String str) {
        ge.i.e(str, "name");
        return new h1.e(str);
    }

    public static void n(Class cls, ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, reflectiveOperationException);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00b7 A[Catch: all -> 0x00b3, PHI: r2
      0x00b7: PHI (r2v1 java.lang.Thread) = (r2v0 java.lang.Thread), (r2v11 java.lang.Thread) binds: [B:7:0x000c, B:47:0x00b0] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #3 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:46:0x00ae, B:61:0x00e5, B:12:0x0023, B:52:0x00b6, B:53:0x00b7, B:64:0x00e9, B:65:0x00ea, B:13:0x0024, B:15:0x0031, B:25:0x004b, B:26:0x0052, B:28:0x005d, B:34:0x0072, B:35:0x0079, B:43:0x008a, B:44:0x00ac, B:18:0x0040, B:54:0x00b8, B:60:0x00e4, B:59:0x00c2), top: B:76:0x0003, inners: #2, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized java.lang.ClassLoader o() {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.e.o():java.lang.ClassLoader");
    }

    public static boolean p(byte b8) {
        return b8 > -65;
    }

    public abstract List e(String str, List list);

    public int hashCode() {
        switch (this.f14126a) {
            case 2:
                return toString().hashCode();
            default:
                return super.hashCode();
        }
    }

    public String toString() {
        switch (this.f14126a) {
            case 2:
                String strC = ge.q.a(getClass()).c();
                ge.i.b(strC);
                return strC;
            default:
                return super.toString();
        }
    }
}
