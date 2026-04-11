package hc;

import android.content.Intent;
import androidx.media3.decoder.DecoderInputBuffer;
import com.playz.tv.activities.MainActivity;
import com.playz.tv.activities.PlayerActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements pc.l, nc.w, ic.o {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6047u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f6048v;

    public /* synthetic */ l(PlayerActivity playerActivity, int i) {
        this.f6047u = i;
        this.f6048v = playerActivity;
    }

    @Override // ic.o
    public void a(String str, String str2, String str3, String str4, int i, boolean z2) {
        PlayerActivity playerActivity = this.f6048v;
        playerActivity.f3628g0 = str;
        playerActivity.f3629h0 = str2;
        playerActivity.f3630i0 = str3;
        playerActivity.f3641u0 = i;
        playerActivity.f3631j0 = str4;
        playerActivity.l0 = z2;
        playerActivity.A(str, str2, str3, str4, null);
    }

    @Override // nc.w
    public void c() {
        int i = PlayerActivity.M0;
        PlayerActivity playerActivity = this.f6048v;
        Intent intent = new Intent(playerActivity, (Class<?>) MainActivity.class);
        intent.putExtra("appDetail", playerActivity.G0);
        playerActivity.startActivity(intent);
        playerActivity.finish();
    }

    @Override // pc.l
    public void f(String str, boolean z2) {
        switch (this.f6047u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = PlayerActivity.M0;
                PlayerActivity playerActivity = this.f6048v;
                if (!z2) {
                    playerActivity.A("https://pro.com", "pro", null, null, null);
                } else {
                    playerActivity.E(str, false);
                }
                break;
            case 3:
                int i10 = PlayerActivity.M0;
                PlayerActivity playerActivity2 = this.f6048v;
                playerActivity2.getClass();
                if (z2) {
                    try {
                        JSONObject jSONObject = new JSONArray(str).getJSONObject(0);
                        oc.a aVarP = uc.b.p(playerActivity2, playerActivity2.V, jSONObject);
                        playerActivity2.G0 = aVarP;
                        aVarP.E = "no";
                        playerActivity2.H0 = jSONObject.optString("app_versions", "5,6");
                    } catch (IndexOutOfBoundsException | JSONException unused) {
                        return;
                    }
                }
                break;
            default:
                int i11 = PlayerActivity.M0;
                PlayerActivity playerActivity3 = this.f6048v;
                if (!z2) {
                    playerActivity3.A("https://pro.com", "pro", null, null, null);
                } else {
                    playerActivity3.E(str, false);
                }
                break;
        }
    }
}
