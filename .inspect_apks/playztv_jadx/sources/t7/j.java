package t7;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.Rect;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.google.android.gms.internal.measurement.d7;
import com.google.android.gms.internal.measurement.e9;
import com.google.android.gms.internal.measurement.f7;
import com.google.android.gms.internal.measurement.g9;
import com.google.android.gms.internal.measurement.h8;
import com.google.android.gms.internal.measurement.i7;
import com.google.android.gms.internal.measurement.j8;
import com.google.android.gms.internal.measurement.k7;
import com.google.android.gms.internal.measurement.o7;
import com.google.android.gms.internal.measurement.q7;
import com.google.android.gms.internal.measurement.u7;
import com.google.android.gms.internal.measurement.w7;
import com.google.android.gms.internal.measurement.x6;
import com.google.android.gms.internal.measurement.z6;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class j implements b8.c, bb.e, cb.a, com.bumptech.glide.manager.f, f6.a, e7.b, j2.w, k8.f, k8.e0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static j f12312v;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f12313u;

    public /* synthetic */ j(int i) {
        this.f12313u = i;
    }

    public static j p(Context context, int i) {
        cf.l.g("Cannot create a CalendarItemStyle with a styleResId of 0", i != 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, p8.l.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(p8.l.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(p8.l.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(p8.l.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(p8.l.MaterialCalendarItem_android_insetBottom, 0));
        a.a.i(context, typedArrayObtainStyledAttributes, p8.l.MaterialCalendarItem_itemFillColor);
        a.a.i(context, typedArrayObtainStyledAttributes, p8.l.MaterialCalendarItem_itemTextColor);
        a.a.i(context, typedArrayObtainStyledAttributes, p8.l.MaterialCalendarItem_itemStrokeColor);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(p8.l.MaterialCalendarItem_itemStrokeWidth, 0);
        q9.k.a(context, typedArrayObtainStyledAttributes.getResourceId(p8.l.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(p8.l.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).a();
        typedArrayObtainStyledAttributes.recycle();
        j jVar = new j(8);
        cf.l.h(rect.left);
        cf.l.h(rect.top);
        cf.l.h(rect.right);
        cf.l.h(rect.bottom);
        return jVar;
    }

    public static Path q(float f, float f4, float f10, float f11) {
        Path path = new Path();
        path.moveTo(f, f4);
        path.lineTo(f10, f11);
        return path;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0045, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0082, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006c A[EDGE_INSN: B:92:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085], EDGE_INSN: B:93:0x006c->B:46:0x006c BREAK  A[LOOP:2: B:47:0x006e->B:58:0x0085, LOOP_LABEL: LOOP:2: B:47:0x006e->B:58:0x0085]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a2 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean r(g1.b r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.j.r(g1.b, android.text.Editable, int, int, boolean):boolean");
    }

    @Override // k8.f
    public String B(String str, String str2) {
        return null;
    }

    @Override // k8.e0
    public Object a() {
        switch (this.f12313u) {
            case 16:
                e9.f2961v.get();
                Boolean bool = (Boolean) g9.f3029j.a();
                bool.getClass();
                return bool;
            case 17:
                e9.f2961v.get();
                Boolean bool2 = (Boolean) g9.f3022a.a();
                bool2.getClass();
                return bool2;
            case 18:
                i7.f3057v.get();
                Boolean bool3 = (Boolean) k7.f3081c.a();
                bool3.getClass();
                return bool3;
            case 19:
                o7.f3141v.get();
                Boolean bool4 = (Boolean) q7.f3164c.a();
                bool4.getClass();
                return bool4;
            case 20:
                u7.f3210v.get();
                Boolean bool5 = (Boolean) w7.f3229a.a();
                bool5.getClass();
                return bool5;
            case 21:
                i7.f3057v.get();
                Boolean bool6 = (Boolean) k7.f3080b.a();
                bool6.getClass();
                return bool6;
            case 22:
                h8.f3040v.get();
                Boolean bool7 = (Boolean) j8.f3067a.a();
                bool7.getClass();
                return bool7;
            case 23:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.T.a()).longValue());
            case 24:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.f3279p.a()).longValue());
            case 25:
                x6.f3236v.get();
                Long l10 = (Long) z6.f3268d0.a();
                l10.getClass();
                return l10;
            case 26:
                x6.f3236v.get();
                Long l11 = (Long) z6.B.a();
                l11.getClass();
                return l11;
            case 27:
                x6.f3236v.get();
                Long l12 = (Long) z6.F.a();
                l12.getClass();
                return l12;
            case 28:
                d7.f2938v.get();
                Boolean bool8 = (Boolean) f7.f2973c.a();
                bool8.getClass();
                return bool8;
            default:
                x6.f3236v.get();
                Long l13 = (Long) z6.f3274k.a();
                l13.getClass();
                return l13;
        }
    }

    @Override // bb.e
    public bb.c b(k8.c0 c0Var, JSONObject jSONObject) throws JSONException {
        jSONObject.optInt("settings_version", 0);
        int iOptInt = jSONObject.optInt("cache_duration", 3600);
        double dOptDouble = jSONObject.optDouble("on_demand_upload_rate_per_minute", 10.0d);
        double dOptDouble2 = jSONObject.optDouble("on_demand_backoff_base", 1.2d);
        int iOptInt2 = jSONObject.optInt("on_demand_backoff_step_duration_seconds", 60);
        b8.l lVar = jSONObject.has("session") ? new b8.l(jSONObject.getJSONObject("session").optInt("max_custom_exception_events", 8)) : new b8.l(new JSONObject().optInt("max_custom_exception_events", 8));
        JSONObject jSONObject2 = jSONObject.getJSONObject("features");
        return new bb.c(jSONObject.has("expires_at") ? jSONObject.optLong("expires_at") : (((long) iOptInt) * 1000) + System.currentTimeMillis(), lVar, new bb.b(jSONObject2.optBoolean("collect_reports", true), jSONObject2.optBoolean("collect_anrs", false), jSONObject2.optBoolean("collect_build_ids", false)), dOptDouble, dOptDouble2, iOptInt2);
    }

    @Override // j2.w
    public MediaCodecInfo c(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // f6.a
    public Bitmap d(int i, int i10, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i10, config);
    }

    @Override // f6.a
    public Bitmap e(int i, int i10, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i10, config);
    }

    public void f(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // j2.w
    public boolean g(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    @Override // md.a
    public Object get() {
        k8.b0 b0Var = new k8.b0(17);
        HashMap map = new HashMap();
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(z6.d.f14891u, new i7.b(30000L, 86400000L, set));
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(z6.d.f14893w, new i7.b(1000L, 86400000L, set));
        if (set == null) {
            throw new NullPointerException("Null flags");
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(i7.c.f6450v)));
        if (setUnmodifiableSet == null) {
            throw new NullPointerException("Null flags");
        }
        map.put(z6.d.f14892v, new i7.b(86400000L, 86400000L, setUnmodifiableSet));
        if (map.keySet().size() < z6.d.values().length) {
            throw new IllegalStateException("Not all priorities have been configured");
        }
        new HashMap();
        return new i7.a(b0Var, map);
    }

    @Override // j2.w
    public int h() {
        return MediaCodecList.getCodecCount();
    }

    @Override // b8.c
    public int i(Context context, String str) {
        return b8.f.a(context, str);
    }

    @Override // j2.w
    public boolean k(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "secure-playback".equals(str) && "video/avc".equals(str2);
    }

    @Override // b8.c
    public int n(Context context, String str, boolean z2) {
        return b8.f.d(context, str, z2);
    }

    @Override // j2.w
    public boolean o() {
        return false;
    }

    @Override // cb.a
    public StackTraceElement[] y(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= 1024) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[1024];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, 512);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - 512, stackTraceElementArr2, 512, 512);
        return stackTraceElementArr2;
    }

    public j(Context context) {
        this.f12313u = 1;
    }

    @Override // f6.a
    public void m() {
    }

    @Override // f6.a
    public void j(int i) {
    }

    @Override // com.bumptech.glide.manager.f
    public void l(h.j jVar) {
    }
}
