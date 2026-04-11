package o8;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.google.android.gms.internal.measurement.b9;
import com.google.android.gms.internal.measurement.d7;
import com.google.android.gms.internal.measurement.d8;
import com.google.android.gms.internal.measurement.f7;
import com.google.android.gms.internal.measurement.l7;
import com.google.android.gms.internal.measurement.n8;
import com.google.android.gms.internal.measurement.p8;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class j implements a7.b, z7.b, com.bumptech.glide.manager.f, f9.w {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static j f9669w;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9673v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ j f9670x = new j(11);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ j f9671y = new j(12);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ j f9672z = new j(13);
    public static final /* synthetic */ j A = new j(14);
    public static final /* synthetic */ j B = new j(15);
    public static final /* synthetic */ j C = new j(16);
    public static final /* synthetic */ j D = new j(17);
    public static final /* synthetic */ j E = new j(18);
    public static final /* synthetic */ j F = new j(19);
    public static final /* synthetic */ j G = new j(20);
    public static final /* synthetic */ j H = new j(21);
    public static final /* synthetic */ j I = new j(22);
    public static final /* synthetic */ j J = new j(23);
    public static final /* synthetic */ j K = new j(24);
    public static final /* synthetic */ j L = new j(25);
    public static final /* synthetic */ j M = new j(26);
    public static final /* synthetic */ j N = new j(27);
    public static final /* synthetic */ j O = new j(28);
    public static final /* synthetic */ j P = new j(29);

    public /* synthetic */ j(int i) {
        this.f9673v = i;
    }

    public static j h(Context context, int i) {
        com.bumptech.glide.f.d("Cannot create a CalendarItemStyle with a styleResId of 0", i != 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, k9.l.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(k9.l.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(k9.l.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(k9.l.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(k9.l.MaterialCalendarItem_android_insetBottom, 0));
        com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, k9.l.MaterialCalendarItem_itemFillColor);
        com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, k9.l.MaterialCalendarItem_itemTextColor);
        com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, k9.l.MaterialCalendarItem_itemStrokeColor);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(k9.l.MaterialCalendarItem_itemStrokeWidth, 0);
        ka.m.a(context, typedArrayObtainStyledAttributes.getResourceId(k9.l.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(k9.l.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).a();
        typedArrayObtainStyledAttributes.recycle();
        j jVar = new j(9);
        com.bumptech.glide.f.e(rect.left);
        com.bumptech.glide.f.e(rect.top);
        com.bumptech.glide.f.e(rect.right);
        com.bumptech.glide.f.e(rect.bottom);
        return jVar;
    }

    public static cd.g j(int i) {
        if (i == -1) {
            return cd.g.f2168x;
        }
        cd.g gVar = cd.g.f2169y;
        return i != 0 ? i != 1 ? i != 2 ? gVar : cd.g.A : cd.g.f2170z : gVar;
    }

    @Override // f9.w
    public Object a() {
        switch (this.f9673v) {
            case 11:
                return new Boolean(((Boolean) l7.f2521a.b()).booleanValue());
            case 12:
                return new Boolean(((Boolean) d8.f2370a.b()).booleanValue());
            case 13:
                List list = f9.f0.f4108a;
                Boolean bool = (Boolean) b9.f2334a.b();
                bool.getClass();
                return bool;
            case 14:
                List list2 = f9.f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2423l0.b()).longValue());
            case 15:
                List list3 = f9.f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2433r.b()).longValue());
            case 16:
                List list4 = f9.f0.f4108a;
                d7.f2368w.get();
                return (String) f7.N.b();
            case 17:
                List list5 = f9.f0.f4108a;
                d7.f2368w.get();
                Long l10 = (Long) f7.J.b();
                l10.getClass();
                return l10;
            case 18:
                List list6 = f9.f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.O.b()).longValue());
            case 19:
                List list7 = f9.f0.f4108a;
                d7.f2368w.get();
                Long l11 = (Long) f7.I.b();
                l11.getClass();
                return l11;
            case 20:
                List list8 = f9.f0.f4108a;
                d7.f2368w.get();
                Long l12 = (Long) f7.f2416h0.b();
                l12.getClass();
                return l12;
            case 21:
                List list9 = f9.f0.f4108a;
                d7.f2368w.get();
                Long l13 = (Long) f7.f2446y.b();
                l13.getClass();
                return l13;
            case 22:
                List list10 = f9.f0.f4108a;
                d7.f2368w.get();
                return (String) f7.f2415h.b();
            case 23:
                List list11 = f9.f0.f4108a;
                d7.f2368w.get();
                Long l14 = (Long) f7.f2424m.b();
                l14.getClass();
                return l14;
            case 24:
                List list12 = f9.f0.f4108a;
                d7.f2368w.get();
                Long l15 = (Long) f7.H.b();
                l15.getClass();
                return l15;
            case 25:
                List list13 = f9.f0.f4108a;
                n8.f2555w.get();
                Long l16 = (Long) p8.f2578e.b();
                l16.getClass();
                return l16;
            case 26:
                List list14 = f9.f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2435s.b()).longValue());
            case 27:
                List list15 = f9.f0.f4108a;
                d7.f2368w.get();
                Long l17 = (Long) f7.f2409d0.b();
                l17.getClass();
                return l17;
            case 28:
                List list16 = f9.f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2429p.b()).longValue());
            default:
                List list17 = f9.f0.f4108a;
                d7.f2368w.get();
                Long l18 = (Long) f7.f2418j.b();
                l18.getClass();
                return l18;
        }
    }

    @Override // a7.b
    public Bitmap b(int i, int i10, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i10, config);
    }

    @Override // a7.b
    public Bitmap c(int i, int i10, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i10, config);
    }

    @Override // a7.b
    public void d(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // qd.a
    public Object get() {
        f9.b0 b0Var = new f9.b0(13);
        HashMap map = new HashMap();
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(u7.d.f12281v, new d8.c(30000L, 86400000L, set));
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(u7.d.f12283x, new d8.c(1000L, 86400000L, set));
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(d8.d.f3529w)));
        if (setUnmodifiableSet == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(u7.d.f12282w, new d8.c(86400000L, 86400000L, setUnmodifiableSet));
        if (map.keySet().size() < u7.d.values().length) {
            throw new IllegalStateException("Not all priorities have been configured");
        }
        new HashMap();
        return new d8.b(b0Var, map);
    }

    public Signature[] i(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    @Override // a7.b
    public void g() {
    }

    @Override // a7.b
    public void e(int i) {
    }

    @Override // com.bumptech.glide.manager.f
    public void f(h.j jVar) {
    }
}
