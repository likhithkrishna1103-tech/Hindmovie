package q5;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.metrics.LogSessionId;
import android.os.Build;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import l2.t;
import l2.u;
import l2.v;
import l2.w;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements u {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReference f10362e = new AtomicReference();
    public static final nc.l f = new nc.l(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f10363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaDrm f10364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10366d;

    public b(UUID uuid) {
        uuid.getClass();
        UUID uuid2 = v1.f.f12658b;
        y1.d.a("Use C.CLEARKEY_UUID instead", !uuid2.equals(uuid));
        this.f10363a = uuid;
        MediaDrm mediaDrm = new MediaDrm((a0.f14551a >= 27 || !uuid.equals(v1.f.f12659c)) ? uuid : uuid2);
        this.f10364b = mediaDrm;
        this.f10365c = 1;
        if (v1.f.f12660d.equals(uuid) && "ASUS_Z00AD".equals(Build.MODEL)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    @Override // l2.u
    public final void a(byte[] bArr, byte[] bArr2) {
        this.f10364b.restoreKeys(bArr, bArr2);
    }

    @Override // l2.u
    public final Map b(byte[] bArr) {
        return this.f10364b.queryKeyStatus(bArr);
    }

    @Override // l2.u
    public final void c(byte[] bArr, h2.l lVar) {
        if (a0.f14551a >= 31) {
            try {
                MediaDrm mediaDrm = this.f10364b;
                LogSessionId logSessionIdA = lVar.a();
                LogSessionId unused = LogSessionId.LOG_SESSION_ID_NONE;
                if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                    return;
                }
                MediaDrm.PlaybackComponent playbackComponent = mediaDrm.getPlaybackComponent(bArr);
                playbackComponent.getClass();
                i2.a.i(playbackComponent).setLogSessionId(logSessionIdA);
            } catch (UnsupportedOperationException unused2) {
                y1.b.p("CustomFrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // l2.u
    public final void d(byte[] bArr) {
        this.f10364b.closeSession(bArr);
    }

    @Override // l2.u
    public final void e(p6.c cVar) {
        this.f10364b.setOnEventListener(new w(this, cVar, 1));
    }

    @Override // l2.u
    public final byte[] f(byte[] bArr, byte[] bArr2) {
        if (v1.f.f12659c.equals(this.f10363a) && a0.f14551a < 27) {
            try {
                JSONObject jSONObject = new JSONObject(a0.o(bArr2));
                StringBuilder sb = new StringBuilder("{\"keys\":[");
                JSONArray jSONArray = jSONObject.getJSONArray("keys");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    sb.append("{\"k\":\"");
                    sb.append(jSONObject2.getString("k").replace('-', '+').replace('_', '/'));
                    sb.append("\",\"kid\":\"");
                    sb.append(jSONObject2.getString("kid").replace('-', '+').replace('_', '/'));
                    sb.append("\",\"kty\":\"");
                    sb.append(jSONObject2.getString("kty"));
                    sb.append("\"}");
                }
                sb.append("]}");
                bArr2 = sb.toString().getBytes(StandardCharsets.UTF_8);
            } catch (JSONException e9) {
                y1.b.h("ClearKeyUtil", "Failed to adjust response data: ".concat(a0.o(bArr2)), e9);
            }
        }
        return this.f10364b.provideKeyResponse(bArr, bArr2);
    }

    @Override // l2.u
    public final t g() {
        MediaDrm.ProvisionRequest provisionRequest = this.f10364b.getProvisionRequest();
        return new t(provisionRequest.getDefaultUrl(), provisionRequest.getData());
    }

    @Override // l2.u
    public final void h(byte[] bArr) throws DeniedByServerException {
        this.f10364b.provideProvisionResponse(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01bb  */
    @Override // l2.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final l2.r i(byte[] r17, java.util.List r18, int r19, java.util.HashMap r20) throws android.media.NotProvisionedException {
        /*
            Method dump skipped, instruction units count: 631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q5.b.i(byte[], java.util.List, int, java.util.HashMap):l2.r");
    }

    @Override // l2.u
    public final int j() {
        return 2;
    }

    @Override // l2.u
    public final e2.b k(byte[] bArr) {
        int i = a0.f14551a;
        UUID uuid = this.f10363a;
        if (i < 27 && Objects.equals(uuid, v1.f.f12659c)) {
            uuid = v1.f.f12658b;
        }
        return new v(uuid, bArr);
    }

    @Override // l2.u
    public final boolean l(String str, byte[] bArr) throws Throwable {
        MediaCrypto mediaCrypto;
        boolean zEquals = false;
        if (!this.f10366d) {
            return false;
        }
        int i = a0.f14551a;
        UUID uuid = this.f10363a;
        if (i >= 31) {
            boolean zEquals2 = uuid.equals(v1.f.f12660d);
            MediaDrm mediaDrm = this.f10364b;
            if (zEquals2) {
                String propertyString = mediaDrm.getPropertyString("version");
                if (!propertyString.startsWith("v5.") && !propertyString.startsWith("14.") && !propertyString.startsWith("15.") && !propertyString.startsWith("16.0")) {
                    zEquals = true;
                }
            } else {
                zEquals = uuid.equals(v1.f.f12659c);
            }
            if (zEquals) {
                return mediaDrm.requiresSecureDecoder(str, mediaDrm.getSecurityLevel(bArr));
            }
        }
        MediaCrypto mediaCrypto2 = null;
        try {
            try {
                mediaCrypto = new MediaCrypto((i >= 27 || !Objects.equals(uuid, v1.f.f12659c)) ? uuid : v1.f.f12658b, bArr);
            } catch (Throwable th) {
                th = th;
            }
        } catch (MediaCryptoException unused) {
        }
        try {
            boolean zRequiresSecureDecoderComponent = mediaCrypto.requiresSecureDecoderComponent(str);
            mediaCrypto.release();
            return zRequiresSecureDecoderComponent;
        } catch (MediaCryptoException unused2) {
            mediaCrypto2 = mediaCrypto;
            boolean z10 = !uuid.equals(v1.f.f12659c);
            if (mediaCrypto2 != null) {
                mediaCrypto2.release();
            }
            return z10;
        } catch (Throwable th2) {
            th = th2;
            mediaCrypto2 = mediaCrypto;
            if (mediaCrypto2 != null) {
                mediaCrypto2.release();
            }
            throw th;
        }
    }

    @Override // l2.u
    public final byte[] m() {
        return this.f10364b.openSession();
    }

    @Override // l2.u
    public final synchronized void release() {
        int i = this.f10365c - 1;
        this.f10365c = i;
        if (i == 0) {
            this.f10364b.release();
        }
    }
}
