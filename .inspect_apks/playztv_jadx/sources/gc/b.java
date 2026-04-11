package gc;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.metrics.LogSessionId;
import android.os.Build;
import f2.t;
import f2.u;
import f2.v;
import f2.w;
import g4.s0;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements u {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReference f5367e = new AtomicReference();
    public static final s0 f = new s0(26);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f5368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaDrm f5369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5371d;

    public b(UUID uuid) {
        uuid.getClass();
        UUID uuid2 = p1.g.f9746b;
        s1.d.a("Use C.CLEARKEY_UUID instead", !uuid2.equals(uuid));
        this.f5368a = uuid;
        MediaDrm mediaDrm = new MediaDrm((b0.f11647a >= 27 || !uuid.equals(p1.g.f9747c)) ? uuid : uuid2);
        this.f5369b = mediaDrm;
        this.f5370c = 1;
        if (p1.g.f9748d.equals(uuid) && "ASUS_Z00AD".equals(Build.MODEL)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    @Override // f2.u
    public final void a(byte[] bArr, byte[] bArr2) {
        this.f5369b.restoreKeys(bArr, bArr2);
    }

    @Override // f2.u
    public final Map b(byte[] bArr) {
        return this.f5369b.queryKeyStatus(bArr);
    }

    @Override // f2.u
    public final void c(byte[] bArr) {
        this.f5369b.closeSession(bArr);
    }

    @Override // f2.u
    public final byte[] d(byte[] bArr, byte[] bArr2) {
        if (p1.g.f9747c.equals(this.f5368a) && b0.f11647a < 27) {
            try {
                JSONObject jSONObject = new JSONObject(b0.o(bArr2));
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
                s1.b.h("ClearKeyUtil", "Failed to adjust response data: ".concat(b0.o(bArr2)), e10);
            }
        }
        return this.f5369b.provideKeyResponse(bArr, bArr2);
    }

    @Override // f2.u
    public final void e(u5.d dVar) {
        this.f5369b.setOnEventListener(new w(this, dVar, 1));
    }

    @Override // f2.u
    public final t f() {
        MediaDrm.ProvisionRequest provisionRequest = this.f5369b.getProvisionRequest();
        return new t(provisionRequest.getDefaultUrl(), provisionRequest.getData());
    }

    @Override // f2.u
    public final void g(byte[] bArr) throws DeniedByServerException {
        this.f5369b.provideProvisionResponse(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01bb  */
    @Override // f2.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final f2.r h(byte[] r17, java.util.List r18, int r19, java.util.HashMap r20) throws android.media.NotProvisionedException {
        /*
            Method dump skipped, instruction units count: 631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: gc.b.h(byte[], java.util.List, int, java.util.HashMap):f2.r");
    }

    @Override // f2.u
    public final int i() {
        return 2;
    }

    @Override // f2.u
    public final y1.b j(byte[] bArr) {
        int i = b0.f11647a;
        UUID uuid = this.f5368a;
        if (i < 27 && Objects.equals(uuid, p1.g.f9747c)) {
            uuid = p1.g.f9746b;
        }
        return new v(uuid, bArr);
    }

    @Override // f2.u
    public final void k(byte[] bArr, b2.o oVar) {
        if (b0.f11647a >= 31) {
            try {
                MediaDrm mediaDrm = this.f5369b;
                LogSessionId logSessionIdA = oVar.a();
                LogSessionId unused = LogSessionId.LOG_SESSION_ID_NONE;
                if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                    return;
                }
                MediaDrm.PlaybackComponent playbackComponent = mediaDrm.getPlaybackComponent(bArr);
                playbackComponent.getClass();
                c2.v.h(playbackComponent).setLogSessionId(logSessionIdA);
            } catch (UnsupportedOperationException unused2) {
                s1.b.p("CustomFrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // f2.u
    public final boolean l(String str, byte[] bArr) throws Throwable {
        MediaCrypto mediaCrypto;
        boolean zEquals = false;
        if (!this.f5371d) {
            return false;
        }
        int i = b0.f11647a;
        UUID uuid = this.f5368a;
        if (i >= 31) {
            boolean zEquals2 = uuid.equals(p1.g.f9748d);
            MediaDrm mediaDrm = this.f5369b;
            if (zEquals2) {
                String propertyString = mediaDrm.getPropertyString("version");
                if (!propertyString.startsWith("v5.") && !propertyString.startsWith("14.") && !propertyString.startsWith("15.") && !propertyString.startsWith("16.0")) {
                    zEquals = true;
                }
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
        return this.f5369b.openSession();
    }

    @Override // f2.u
    public final synchronized void release() {
        int i = this.f5370c - 1;
        this.f5370c = i;
        if (i == 0) {
            this.f5369b.release();
        }
    }
}
