package l8;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import androidx.fragment.app.r0;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f7887c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f7888d = new e();

    public static AlertDialog d(Activity activity, int i, o8.o oVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(o8.n.b(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        String string = i != 1 ? i != 2 ? i != 3 ? resources.getString(R.string.ok) : resources.getString(j8.b.common_google_play_services_enable_button) : resources.getString(j8.b.common_google_play_services_update_button) : resources.getString(j8.b.common_google_play_services_install_button);
        if (string != null) {
            builder.setPositiveButton(string, oVar);
        }
        String strC = o8.n.c(activity, i);
        if (strC != null) {
            builder.setTitle(strC);
        }
        Log.w("GoogleApiAvailability", l0.e.g(i, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    public static void e(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof h.j) {
                r0 r0VarO = ((h.j) activity).o();
                k kVar = new k();
                o8.u.h(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                kVar.I0 = alertDialog;
                if (onCancelListener != null) {
                    kVar.J0 = onCancelListener;
                }
                kVar.U(r0VarO, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        c cVar = new c();
        o8.u.h(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        cVar.f7881v = alertDialog;
        if (onCancelListener != null) {
            cVar.f7882w = onCancelListener;
        }
        cVar.show(fragmentManager, str);
    }

    public final void c(GoogleApiActivity googleApiActivity, int i, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogD = d(googleApiActivity, i, new o8.o(super.a(i, googleApiActivity, "d"), googleApiActivity, 0), googleApiActivity2);
        if (alertDialogD == null) {
            return;
        }
        e(googleApiActivity, alertDialogD, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void f(Context context, int i, PendingIntent pendingIntent) {
        int i10;
        Log.w("GoogleApiAvailability", l0.e.h(i, "GMS core API Availability. ConnectionResult=", ", tag=null"), new IllegalArgumentException());
        if (i == 18) {
            new l(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = i == 6 ? o8.n.e(context, "common_google_play_services_resolution_required_title") : o8.n.c(context, i);
        if (strE == null) {
            strE = context.getResources().getString(j8.b.common_google_play_services_notification_ticker);
        }
        String strD = (i == 6 || i == 19) ? o8.n.d(context, "common_google_play_services_resolution_required_text", o8.n.a(context)) : o8.n.b(context, i);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        o8.u.g(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        h0.m mVar = new h0.m(context, null);
        mVar.f5459m = true;
        mVar.c(16, true);
        mVar.f5453e = h0.m.b(strE);
        h0.k kVar = new h0.k(3, false);
        kVar.f5448x = h0.m.b(strD);
        mVar.e(kVar);
        PackageManager packageManager = context.getPackageManager();
        if (s8.b.f11613c == null) {
            s8.b.f11613c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (s8.b.f11613c.booleanValue()) {
            mVar.f5465s.icon = context.getApplicationInfo().icon;
            mVar.f5456j = 2;
            if (s8.b.f(context)) {
                mVar.f5450b.add(new h0.g(j8.a.common_full_open_on_phone, resources.getString(j8.b.common_open_on_phone), pendingIntent));
            } else {
                mVar.f5454g = pendingIntent;
            }
        } else {
            mVar.f5465s.icon = R.drawable.stat_sys_warning;
            mVar.f5465s.tickerText = h0.m.b(resources.getString(j8.b.common_google_play_services_notification_ticker));
            mVar.f5465s.when = System.currentTimeMillis();
            mVar.f5454g = pendingIntent;
            mVar.f = h0.m.b(strD);
        }
        if (s8.b.d()) {
            if (!s8.b.d()) {
                throw new IllegalStateException();
            }
            synchronized (f7887c) {
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String string = context.getResources().getString(j8.b.common_google_play_services_notification_channel_name);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(a7.h.d(string));
            } else if (!string.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(string);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            mVar.f5463q = "com.google.android.gms.availability";
        }
        Notification notificationA = mVar.a();
        if (i == 1 || i == 2 || i == 3) {
            g.f7891a.set(false);
            i10 = 10436;
        } else {
            i10 = 39789;
        }
        notificationManager.notify(i10, notificationA);
    }

    public final void g(Activity activity, n8.e eVar, int i, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogD = d(activity, i, new o8.o(super.a(i, activity, "d"), eVar, 1), onCancelListener);
        if (alertDialogD == null) {
            return;
        }
        e(activity, alertDialogD, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
