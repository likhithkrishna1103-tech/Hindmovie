package r5;

import android.content.Intent;
import androidx.media3.decoder.DecoderInputBuffer;
import app.cricfy.tv.activities.MainActivity;
import app.cricfy.tv.activities.PlayerActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x5.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements z5.k, t, s5.m {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f10873v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f10874w;

    public /* synthetic */ l(PlayerActivity playerActivity, int i) {
        this.f10873v = i;
        this.f10874w = playerActivity;
    }

    @Override // x5.t
    public void a() {
        int i = PlayerActivity.I0;
        PlayerActivity playerActivity = this.f10874w;
        Intent intent = new Intent(playerActivity, (Class<?>) MainActivity.class);
        intent.putExtra("appDetail", playerActivity.E0);
        playerActivity.startActivity(intent);
        playerActivity.finish();
    }

    @Override // s5.m
    public void b(String str, String str2, String str3, String str4, int i, boolean z10) {
        PlayerActivity playerActivity = this.f10874w;
        playerActivity.f1523h0 = str;
        playerActivity.f1524i0 = str2;
        playerActivity.f1525j0 = str3;
        playerActivity.f1534t0 = i;
        playerActivity.f1526k0 = str4;
        playerActivity.f1527l0 = z10;
        playerActivity.A(str, str2, str3, str4, null);
    }

    @Override // z5.k
    public void f(String str, boolean z10) {
        switch (this.f10873v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = PlayerActivity.I0;
                PlayerActivity playerActivity = this.f10874w;
                if (!z10) {
                    playerActivity.A("https://pro.com", "pro", null, null, null);
                } else {
                    playerActivity.D(str, false);
                }
                break;
            case 1:
            default:
                int i10 = PlayerActivity.I0;
                PlayerActivity playerActivity2 = this.f10874w;
                if (!z10) {
                    playerActivity2.A("https://pro.com", "pro", null, null, null);
                } else {
                    playerActivity2.D(str, false);
                }
                break;
            case 2:
                int i11 = PlayerActivity.I0;
                PlayerActivity playerActivity3 = this.f10874w;
                playerActivity3.getClass();
                if (z10) {
                    try {
                        JSONObject jSONObject = new JSONArray(str).getJSONObject(0);
                        y5.a aVarK = com.bumptech.glide.e.k(playerActivity3, playerActivity3.W, jSONObject);
                        playerActivity3.E0 = aVarK;
                        aVarK.H = "no";
                        playerActivity3.F0 = jSONObject.optString("app_versions", "5,6");
                    } catch (IndexOutOfBoundsException | JSONException unused) {
                        return;
                    }
                }
                break;
        }
    }
}
