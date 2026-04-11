package o8;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f9685v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Intent f9686w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f9687x;

    public /* synthetic */ o(Intent intent, Object obj, int i) {
        this.f9685v = i;
        this.f9686w = intent;
        this.f9687x = obj;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, n8.e] */
    public final void a() {
        switch (this.f9685v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Intent intent = this.f9686w;
                if (intent != null) {
                    ((GoogleApiActivity) this.f9687x).startActivityForResult(intent, 2);
                }
                break;
            default:
                Intent intent2 = this.f9686w;
                if (intent2 != null) {
                    this.f9687x.a(intent2, 2);
                }
                break;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException e9) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e9);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
