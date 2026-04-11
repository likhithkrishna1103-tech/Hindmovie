package n8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.firebase.messaging.FirebaseMessaging;
import f9.i3;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8889a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f8890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f8891c;

    public /* synthetic */ m() {
    }

    public void a() {
        if (Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3))) {
            Log.d("FirebaseMessaging", "Connectivity change received registered");
        }
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        i3 i3Var = (i3) this.f8891c;
        if (i3Var != null) {
            Context context = ((FirebaseMessaging) i3Var.f4221y).f3039b;
            this.f8890b = context;
            context.registerReceiver(this, intentFilter);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.f8889a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Uri data = intent.getData();
                if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
                    Object obj = ((i2.k) this.f8891c).f6086w;
                    throw null;
                }
                return;
            default:
                i3 i3Var = (i3) this.f8891c;
                if (i3Var != null && i3Var.a()) {
                    if (Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3))) {
                        Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                    }
                    i3 i3Var2 = (i3) this.f8891c;
                    ((FirebaseMessaging) i3Var2.f4221y).getClass();
                    FirebaseMessaging.b(i3Var2, 0L);
                    Context context2 = this.f8890b;
                    if (context2 != null) {
                        context2.unregisterReceiver(this);
                    }
                    this.f8891c = null;
                    return;
                }
                return;
        }
    }

    public m(i2.k kVar) {
        this.f8891c = kVar;
    }
}
