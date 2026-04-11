package l2;

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
import k4.r0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class x implements u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r0 f7686d = new r0(18);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f7687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaDrm f7688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7689c;

    public x(UUID uuid) {
        uuid.getClass();
        UUID uuid2 = v1.f.f12658b;
        y1.d.a("Use C.CLEARKEY_UUID instead", !uuid2.equals(uuid));
        this.f7687a = uuid;
        MediaDrm mediaDrm = new MediaDrm((Build.VERSION.SDK_INT >= 27 || !uuid.equals(v1.f.f12659c)) ? uuid : uuid2);
        this.f7688b = mediaDrm;
        this.f7689c = 1;
        if (v1.f.f12660d.equals(uuid) && "ASUS_Z00AD".equals(Build.MODEL)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    @Override // l2.u
    public final void a(byte[] bArr, byte[] bArr2) {
        this.f7688b.restoreKeys(bArr, bArr2);
    }

    @Override // l2.u
    public final Map b(byte[] bArr) {
        return this.f7688b.queryKeyStatus(bArr);
    }

    @Override // l2.u
    public final void c(byte[] bArr, h2.l lVar) {
        if (Build.VERSION.SDK_INT >= 31) {
            try {
                MediaDrm mediaDrm = this.f7688b;
                LogSessionId logSessionIdA = lVar.a();
                LogSessionId unused = LogSessionId.LOG_SESSION_ID_NONE;
                if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                    return;
                }
                MediaDrm.PlaybackComponent playbackComponent = mediaDrm.getPlaybackComponent(bArr);
                playbackComponent.getClass();
                i2.a.i(playbackComponent).setLogSessionId(logSessionIdA);
            } catch (UnsupportedOperationException unused2) {
                y1.b.p("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // l2.u
    public final void d(byte[] bArr) {
        this.f7688b.closeSession(bArr);
    }

    @Override // l2.u
    public final void e(p6.c cVar) {
        this.f7688b.setOnEventListener(new w(this, cVar, 0));
    }

    @Override // l2.u
    public final byte[] f(byte[] bArr, byte[] bArr2) {
        if (v1.f.f12659c.equals(this.f7687a) && Build.VERSION.SDK_INT < 27) {
            try {
                JSONObject jSONObject = new JSONObject(y1.a0.o(bArr2));
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
                y1.b.h("ClearKeyUtil", "Failed to adjust response data: ".concat(y1.a0.o(bArr2)), e9);
            }
        }
        return this.f7688b.provideKeyResponse(bArr, bArr2);
    }

    @Override // l2.u
    public final t g() {
        MediaDrm.ProvisionRequest provisionRequest = this.f7688b.getProvisionRequest();
        return new t(provisionRequest.getDefaultUrl(), provisionRequest.getData());
    }

    @Override // l2.u
    public final void h(byte[] bArr) throws DeniedByServerException {
        this.f7688b.provideProvisionResponse(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d0  */
    @Override // l2.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final l2.r i(byte[] r17, java.util.List r18, int r19, java.util.HashMap r20) throws android.media.NotProvisionedException {
        /*
            Method dump skipped, instruction units count: 607
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.x.i(byte[], java.util.List, int, java.util.HashMap):l2.r");
    }

    @Override // l2.u
    public final int j() {
        return 2;
    }

    @Override // l2.u
    public final e2.b k(byte[] bArr) {
        int i = Build.VERSION.SDK_INT;
        UUID uuid = this.f7687a;
        if (i < 27 && Objects.equals(uuid, v1.f.f12659c)) {
            uuid = v1.f.f12658b;
        }
        return new v(uuid, bArr);
    }

    @Override // l2.u
    public final boolean l(String str, byte[] bArr) throws Throwable {
        MediaCrypto mediaCrypto;
        boolean zEquals;
        int i = Build.VERSION.SDK_INT;
        UUID uuid = this.f7687a;
        if (i >= 31) {
            boolean zEquals2 = uuid.equals(v1.f.f12660d);
            MediaDrm mediaDrm = this.f7688b;
            if (zEquals2) {
                String propertyString = mediaDrm.getPropertyString("version");
                zEquals = (propertyString.startsWith("v5.") || propertyString.startsWith("14.") || propertyString.startsWith("15.") || propertyString.startsWith("16.0")) ? false : true;
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
        return this.f7688b.openSession();
    }

    @Override // l2.u
    public final synchronized void release() {
        int i = this.f7689c - 1;
        this.f7689c = i;
        if (i == 0) {
            this.f7688b.release();
        }
    }
}
