package f2;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x implements u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b2.f f4753d = new b2.f(16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f4754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaDrm f4755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4756c;

    public x(UUID uuid) {
        uuid.getClass();
        UUID uuid2 = p1.g.f9746b;
        s1.d.a("Use C.CLEARKEY_UUID instead", !uuid2.equals(uuid));
        this.f4754a = uuid;
        MediaDrm mediaDrm = new MediaDrm((Build.VERSION.SDK_INT >= 27 || !uuid.equals(p1.g.f9747c)) ? uuid : uuid2);
        this.f4755b = mediaDrm;
        this.f4756c = 1;
        if (p1.g.f9748d.equals(uuid) && "ASUS_Z00AD".equals(Build.MODEL)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    @Override // f2.u
    public final void a(byte[] bArr, byte[] bArr2) {
        this.f4755b.restoreKeys(bArr, bArr2);
    }

    @Override // f2.u
    public final Map b(byte[] bArr) {
        return this.f4755b.queryKeyStatus(bArr);
    }

    @Override // f2.u
    public final void c(byte[] bArr) {
        this.f4755b.closeSession(bArr);
    }

    @Override // f2.u
    public final byte[] d(byte[] bArr, byte[] bArr2) {
        if (p1.g.f9747c.equals(this.f4754a) && Build.VERSION.SDK_INT < 27) {
            try {
                JSONObject jSONObject = new JSONObject(s1.b0.o(bArr2));
                StringBuilder sb2 = new StringBuilder("{\"keys\":[");
                JSONArray jSONArray = jSONObject.getJSONArray("keys");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (i != 0) {
                        sb2.append(",");
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    sb2.append("{\"k\":\"");
                    sb2.append(jSONObject2.getString("k").replace('-', '+').replace('_', '/'));
                    sb2.append("\",\"kid\":\"");
                    sb2.append(jSONObject2.getString("kid").replace('-', '+').replace('_', '/'));
                    sb2.append("\",\"kty\":\"");
                    sb2.append(jSONObject2.getString("kty"));
                    sb2.append("\"}");
                }
                sb2.append("]}");
                bArr2 = sb2.toString().getBytes(StandardCharsets.UTF_8);
            } catch (JSONException e10) {
                s1.b.h("ClearKeyUtil", "Failed to adjust response data: ".concat(s1.b0.o(bArr2)), e10);
            }
        }
        return this.f4755b.provideKeyResponse(bArr, bArr2);
    }

    @Override // f2.u
    public final void e(u5.d dVar) {
        this.f4755b.setOnEventListener(new w(this, dVar, 0));
    }

    @Override // f2.u
    public final t f() {
        MediaDrm.ProvisionRequest provisionRequest = this.f4755b.getProvisionRequest();
        return new t(provisionRequest.getDefaultUrl(), provisionRequest.getData());
    }

    @Override // f2.u
    public final void g(byte[] bArr) throws DeniedByServerException {
        this.f4755b.provideProvisionResponse(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d0  */
    @Override // f2.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f2.r h(byte[] r17, java.util.List r18, int r19, java.util.HashMap r20) throws android.media.NotProvisionedException {
        /*
            Method dump skipped, instruction units count: 607
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f2.x.h(byte[], java.util.List, int, java.util.HashMap):f2.r");
    }

    @Override // f2.u
    public final int i() {
        return 2;
    }

    @Override // f2.u
    public final y1.b j(byte[] bArr) {
        int i = Build.VERSION.SDK_INT;
        UUID uuid = this.f4754a;
        if (i < 27 && Objects.equals(uuid, p1.g.f9747c)) {
            uuid = p1.g.f9746b;
        }
        return new v(uuid, bArr);
    }

    @Override // f2.u
    public final void k(byte[] bArr, b2.o oVar) {
        if (Build.VERSION.SDK_INT >= 31) {
            try {
                MediaDrm mediaDrm = this.f4755b;
                LogSessionId logSessionIdA = oVar.a();
                LogSessionId unused = LogSessionId.LOG_SESSION_ID_NONE;
                if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                    return;
                }
                MediaDrm.PlaybackComponent playbackComponent = mediaDrm.getPlaybackComponent(bArr);
                playbackComponent.getClass();
                c2.v.h(playbackComponent).setLogSessionId(logSessionIdA);
            } catch (UnsupportedOperationException unused2) {
                s1.b.p("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // f2.u
    public final boolean l(String str, byte[] bArr) throws Throwable {
        MediaCrypto mediaCrypto;
        boolean zEquals;
        int i = Build.VERSION.SDK_INT;
        UUID uuid = this.f4754a;
        if (i >= 31) {
            boolean zEquals2 = uuid.equals(p1.g.f9748d);
            MediaDrm mediaDrm = this.f4755b;
            if (zEquals2) {
                String propertyString = mediaDrm.getPropertyString("version");
                zEquals = (propertyString.startsWith("v5.") || propertyString.startsWith("14.") || propertyString.startsWith("15.") || propertyString.startsWith("16.0")) ? false : true;
            } else {
                zEquals = uuid.equals(p1.g.f9747c);
            }
            if (zEquals) {
                return mediaDrm.requiresSecureDecoder(str, mediaDrm.getSecurityLevel(bArr));
            }
        }
        MediaCrypto mediaCrypto2 = null;
        try {
            try {
                mediaCrypto = new MediaCrypto((i >= 27 || !Objects.equals(uuid, p1.g.f9747c)) ? uuid : p1.g.f9746b, bArr);
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
            boolean z2 = !uuid.equals(p1.g.f9747c);
            if (mediaCrypto2 != null) {
                mediaCrypto2.release();
            }
            return z2;
        } catch (Throwable th2) {
            th = th2;
            mediaCrypto2 = mediaCrypto;
            if (mediaCrypto2 != null) {
                mediaCrypto2.release();
            }
            throw th;
        }
    }

    @Override // f2.u
    public final byte[] m() {
        return this.f4755b.openSession();
    }

    @Override // f2.u
    public final synchronized void release() {
        int i = this.f4756c - 1;
        this.f4756c = i;
        if (i == 0) {
            this.f4755b.release();
        }
    }
}
