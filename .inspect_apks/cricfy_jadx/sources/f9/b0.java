package f9;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.d7;
import com.google.android.gms.internal.measurement.f7;
import com.google.android.gms.internal.measurement.h9;
import com.google.android.gms.internal.measurement.q8;
import com.google.android.gms.internal.measurement.q9;
import com.google.android.gms.internal.measurement.s8;
import com.google.android.gms.internal.measurement.u7;
import com.google.android.gms.internal.measurement.x7;
import com.google.android.gms.internal.measurement.z6;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 implements w, g7.f0, g8.a, lb.a, n2.s, n.v, p2.v, pb.c, t0.s, t7.c, vb.c, w8.b, wb.a {
    public static b0 H;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4023v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ b0 f4019w = new b0(0);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ b0 f4020x = new b0(1);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ b0 f4021y = new b0(2);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ b0 f4022z = new b0(3);
    public static final /* synthetic */ b0 A = new b0(4);
    public static final /* synthetic */ b0 B = new b0(5);
    public static final /* synthetic */ b0 C = new b0(6);
    public static final /* synthetic */ b0 D = new b0(7);
    public static final /* synthetic */ b0 E = new b0(8);
    public static final /* synthetic */ b0 F = new b0(9);
    public static final /* synthetic */ b0 G = new b0(10);

    public /* synthetic */ b0(int i) {
        this.f4023v = i;
    }

    public static ArrayList w(List list) {
        ge.i.e(list, "protocols");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((kf.v) obj) != kf.v.f7573x) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(sd.l.f0(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            arrayList2.add(((kf.v) obj2).f7576v);
        }
        return arrayList2;
    }

    public static byte[] x(List list) {
        ge.i.e(list, "protocols");
        ag.e eVar = new ag.e();
        ArrayList arrayListW = w(list);
        int size = arrayListW.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListW.get(i);
            i++;
            String str = (String) obj;
            eVar.i0(str.length());
            eVar.o0(str);
        }
        return eVar.A(eVar.f429w);
    }

    public static ya.w y(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((v1.g0) it.next()).f12697b == null) {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                ya.t tVar = new ya.t();
                tVar.l(unsupportedOperationException);
                return tVar;
            }
        }
        return w1.d.l(list);
    }

    @Override // f9.w
    public Object a() {
        switch (this.f4023v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                List list = f0.f4108a;
                d7.f2368w.get();
                return (String) f7.f2420k.b();
            case 1:
                List list2 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.W.b()).longValue());
            case 2:
                List list3 = f0.f4108a;
                d7.f2368w.get();
                Boolean bool = (Boolean) f7.f2406c.b();
                bool.getClass();
                return bool;
            case 3:
                List list4 = f0.f4108a;
                Boolean bool2 = (Boolean) x7.f2726a.b();
                bool2.getClass();
                return bool2;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                List list5 = f0.f4108a;
                Boolean bool3 = (Boolean) q9.f2583a.b();
                bool3.getClass();
                return bool3;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                List list6 = f0.f4108a;
                Boolean bool4 = (Boolean) u7.f2651b.b();
                bool4.getClass();
                return bool4;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                List list7 = f0.f4108a;
                d7.f2368w.get();
                return Integer.valueOf((int) ((Long) f7.f2425m0.b()).longValue());
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                List list8 = f0.f4108a;
                q8.f2581w.get();
                Boolean bool5 = (Boolean) s8.f2623b.b();
                bool5.getClass();
                return bool5;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                List list9 = f0.f4108a;
                Boolean bool6 = (Boolean) z6.f2744a.b();
                bool6.getClass();
                return bool6;
            case 9:
                List list10 = f0.f4108a;
                d7.f2368w.get();
                Long l10 = (Long) f7.f2402a.b();
                l10.getClass();
                return l10;
            default:
                return new Boolean(((Boolean) h9.f2477a.b()).booleanValue());
        }
    }

    @Override // p2.v
    public MediaCodecInfo d(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // w8.b
    public int e(Context context, String str, boolean z10) {
        return w8.d.d(context, str, z10);
    }

    @Override // t7.c
    public void f(Object obj) {
        ((List) obj).clear();
    }

    @Override // w8.b
    public int g(Context context, String str) {
        return w8.d.a(context, str);
    }

    @Override // pb.c
    public String h() {
        return null;
    }

    @Override // vb.c
    public vb.a i(a0 a0Var, JSONObject jSONObject) throws JSONException {
        jSONObject.optInt("settings_version", 0);
        int iOptInt = jSONObject.optInt("cache_duration", 3600);
        double dOptDouble = jSONObject.optDouble("on_demand_upload_rate_per_minute", 10.0d);
        double dOptDouble2 = jSONObject.optDouble("on_demand_backoff_base", 1.2d);
        int iOptInt2 = jSONObject.optInt("on_demand_backoff_step_duration_seconds", 60);
        q6.l lVar = jSONObject.has("session") ? new q6.l(jSONObject.getJSONObject("session").optInt("max_custom_exception_events", 8)) : new q6.l(new JSONObject().optInt("max_custom_exception_events", 8));
        JSONObject jSONObject2 = jSONObject.getJSONObject("features");
        return new vb.a(jSONObject.has("expires_at") ? jSONObject.optLong("expires_at") : (((long) iOptInt) * 1000) + System.currentTimeMillis(), lVar, new i2.g(jSONObject2.optBoolean("collect_reports", true), jSONObject2.optBoolean("collect_anrs", false), jSONObject2.optBoolean("collect_build_ids", false)), dOptDouble, dOptDouble2, iOptInt2);
    }

    @Override // p2.v
    public boolean j(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    @Override // p2.v
    public int k() {
        return MediaCodecList.getCodecCount();
    }

    @Override // g8.a
    public long l() {
        return System.currentTimeMillis();
    }

    @Override // n2.s
    public w2.q m() {
        return new n2.r(n2.o.f8715l, null);
    }

    @Override // n.v
    public boolean n(n.k kVar) {
        return false;
    }

    @Override // wb.a
    public StackTraceElement[] o(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= 1024) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[1024];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, 512);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - 512, stackTraceElementArr2, 512, 512);
        return stackTraceElementArr2;
    }

    @Override // g7.f0
    public void p(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        mediaMetadataRetriever.setDataSource(new g7.e0((ByteBuffer) obj));
    }

    @Override // lb.a
    public void q(Bundle bundle) {
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Skipping logging Crashlytics event to Firebase, no Firebase Analytics", null);
        }
    }

    @Override // p2.v
    public boolean r(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "secure-playback".equals(str) && "video/avc".equals(str2);
    }

    @Override // n2.s
    public w2.q t(n2.o oVar, n2.l lVar) {
        return new n2.r(oVar, lVar);
    }

    @Override // p2.v
    public boolean u() {
        return false;
    }

    @Override // g7.f0
    public void v(MediaExtractor mediaExtractor, Object obj) throws IOException {
        mediaExtractor.setDataSource(new g7.e0((ByteBuffer) obj));
    }

    public b0(Context context) {
        this.f4023v = 11;
    }

    @Override // pb.c
    public void b() {
    }

    @Override // n.v
    public void c(n.k kVar, boolean z10) {
    }

    @Override // pb.c
    public void s(String str, long j4) {
    }

    @Override // t0.s
    public void onScrollLimit(int i, int i10, int i11, boolean z10) {
    }

    @Override // t0.s
    public void onScrollProgress(int i, int i10, int i11, int i12) {
    }
}
