package k8;

import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.a9;
import com.google.android.gms.internal.measurement.d7;
import com.google.android.gms.internal.measurement.f7;
import com.google.android.gms.internal.measurement.j7;
import com.google.android.gms.internal.measurement.l7;
import com.google.android.gms.internal.measurement.l9;
import com.google.android.gms.internal.measurement.n8;
import com.google.android.gms.internal.measurement.n9;
import com.google.android.gms.internal.measurement.p7;
import com.google.android.gms.internal.measurement.p8;
import com.google.android.gms.internal.measurement.q9;
import com.google.android.gms.internal.measurement.r7;
import com.google.android.gms.internal.measurement.s9;
import com.google.android.gms.internal.measurement.v7;
import com.google.android.gms.internal.measurement.x6;
import com.google.android.gms.internal.measurement.x7;
import com.google.android.gms.internal.measurement.y8;
import com.google.android.gms.internal.measurement.z6;
import com.google.firebase.analytics.connector.internal.AnalyticsConnectorRegistrar;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z implements e0, l6.n, l6.c0, na.e, o4.d, o5.b, ra.a, rd.g, u2.d0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7565u;

    public /* synthetic */ z(int i) {
        this.f7565u = i;
    }

    @Override // k8.e0
    public Object a() {
        switch (this.f7565u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                x6.f3236v.get();
                Long l10 = (Long) z6.X.a();
                l10.getClass();
                return l10;
            case 1:
                x6.f3236v.get();
                Long l11 = (Long) z6.D.a();
                l11.getClass();
                return l11;
            case 2:
                d7.f2938v.get();
                Boolean bool = (Boolean) f7.f2974d.a();
                bool.getClass();
                return bool;
            case 3:
                y8.f3250v.get();
                Double d10 = (Double) a9.f2892c.a();
                d10.getClass();
                return d10;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.f3267d.a()).longValue());
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                x6.f3236v.get();
                return Integer.valueOf((int) ((Long) z6.f3285v.a()).longValue());
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                x6.f3236v.get();
                return (String) z6.G.a();
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                x6.f3236v.get();
                return (String) z6.f3270e0.a();
            case 8:
                x6.f3236v.get();
                Long l12 = (Long) z6.H.a();
                l12.getClass();
                return l12;
            case 9:
                x6.f3236v.get();
                Boolean bool2 = (Boolean) z6.f3265c.a();
                bool2.getClass();
                return bool2;
            case 10:
                v7.f3218v.get();
                Boolean bool3 = (Boolean) x7.f3238a.a();
                bool3.getClass();
                return bool3;
            case 11:
                q9.f3165v.get();
                Boolean bool4 = (Boolean) s9.f3193a.a();
                bool4.getClass();
                return bool4;
            case 12:
                p7.f3153v.get();
                Boolean bool5 = (Boolean) r7.f3181a.a();
                bool5.getClass();
                return bool5;
            case 13:
                j7.f3065v.get();
                Boolean bool6 = (Boolean) l7.f3090b.a();
                bool6.getClass();
                return bool6;
            case 14:
                l9.f3091v.get();
                Boolean bool7 = (Boolean) n9.f3131e.a();
                bool7.getClass();
                return bool7;
            default:
                n8.f3125v.get();
                Boolean bool8 = (Boolean) p8.f3156b.a();
                bool8.getClass();
                return bool8;
        }
    }

    @Override // o5.b
    public float d() {
        return 1.0f;
    }

    @Override // na.e
    public Object e(zc.c cVar) {
        return AnalyticsConnectorRegistrar.lambda$getComponents$0(cVar);
    }

    @Override // o5.b
    public boolean h(float f) {
        throw new IllegalStateException("not implemented");
    }

    @Override // o5.b
    public boolean isEmpty() {
        return true;
    }

    @Override // o5.b
    public float j() {
        return 0.0f;
    }

    @Override // o5.b
    public y5.a k() {
        throw new IllegalStateException("not implemented");
    }

    @Override // o5.b
    public boolean n(float f) {
        return false;
    }

    @Override // l6.c0
    public void o(MediaMetadataRetriever mediaMetadataRetriever, Object obj) {
        mediaMetadataRetriever.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
    }

    @Override // ra.a
    public void p(Bundle bundle) {
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Skipping logging Crashlytics event to Firebase, no Firebase Analytics", null);
        }
    }

    @Override // l6.c0
    public void q(MediaExtractor mediaExtractor, Object obj) throws IOException {
        mediaExtractor.setDataSource(((ParcelFileDescriptor) obj).getFileDescriptor());
    }

    @Override // u2.d0
    public /* synthetic */ void f() {
    }

    @Override // u2.d0
    public /* synthetic */ void g() {
    }

    @Override // u2.d0
    public /* synthetic */ void i() {
    }

    @Override // o4.d
    public void l() {
    }

    @Override // l6.n
    public void s() {
    }

    @Override // u2.d0
    public /* synthetic */ void b(p1.r1 r1Var) {
    }

    @Override // l6.n
    public void c(Bitmap bitmap, f6.a aVar) {
    }

    @Override // o4.d
    public void m(int i, Object obj) {
    }
}
