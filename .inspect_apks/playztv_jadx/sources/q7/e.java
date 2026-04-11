package q7;

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
import androidx.fragment.app.n0;
import com.google.android.gms.common.api.GoogleApiActivity;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f11037c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f11038d = new e();

    public static AlertDialog d(Activity activity, int i, t7.o oVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(t7.n.b(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        String string = i != 1 ? i != 2 ? i != 3 ? resources.getString(R.string.ok) : resources.getString(o7.b.common_google_play_services_enable_button) : resources.getString(o7.b.common_google_play_services_update_button) : resources.getString(o7.b.common_google_play_services_install_button);
        if (string != null) {
            builder.setPositiveButton(string, oVar);
        }
        String strC = t7.n.c(activity, i);
        if (strC != null) {
            builder.setTitle(strC);
        }
        Log.w("GoogleApiAvailability", e6.j.l("Creating dialog for Google Play services availability issue. ConnectionResult=", i), new IllegalArgumentException());
        return builder.create();
    }

    public static void e(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof h.j) {
                n0 n0VarO = ((h.j) activity).o();
                j jVar = new j();
                v.i(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                jVar.H0 = alertDialog;
                if (onCancelListener != null) {
                    jVar.I0 = onCancelListener;
                }
                jVar.R(n0VarO, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        c cVar = new c();
        v.i(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        cVar.f11031u = alertDialog;
        if (onCancelListener != null) {
            cVar.f11032v = onCancelListener;
        }
        cVar.show(fragmentManager, str);
    }

    public final void c(GoogleApiActivity googleApiActivity, int i, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogD = d(googleApiActivity, i, new t7.o(super.a(i, googleApiActivity, "d"), googleApiActivity, 0), googleApiActivity2);
        if (alertDialogD == null) {
            return;
        }
        e(googleApiActivity, alertDialogD, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void f(Context context, int i, PendingIntent pendingIntent) {
        int i10;
        Log.w("GoogleApiAvailability", e6.j.j(i, "GMS core API Availability. ConnectionResult=", ", tag=null"), new IllegalArgumentException());
        if (i == 18) {
            new k(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strE = i == 6 ? t7.n.e(context, "common_google_play_services_resolution_required_title") : t7.n.c(context, i);
        if (strE == null) {
            strE = context.getResources().getString(o7.b.common_google_play_services_notification_ticker);
        }
        String strD = (i == 6 || i == 19) ? t7.n.d(context, "common_google_play_services_resolution_required_text", t7.n.a(context)) : t7.n.b(context, i);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        v.h(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        e0.m mVar = new e0.m(context, null);
        mVar.f4266m = true;
        mVar.c(16, true);
        mVar.f4260e = e0.m.b(strE);
        e0.k kVar = new e0.k(1, false);
        kVar.f4255w = e0.m.b(strD);
        mVar.e(kVar);
        PackageManager packageManager = context.getPackageManager();
        if (x7.b.f14297c == null) {
            x7.b.f14297c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (x7.b.f14297c.booleanValue()) {
            mVar.f4272s.icon = context.getApplicationInfo().icon;
            mVar.f4263j = 2;
            if (x7.b.f(context)) {
                mVar.f4257b.add(new e0.g(o7.a.common_full_open_on_phone, resources.getString(o7.b.common_open_on_phone), pendingIntent));
            } else {
                mVar.f4261g = pendingIntent;
            }
        } else {
            mVar.f4272s.icon = R.drawable.stat_sys_warning;
            mVar.f4272s.tickerText = e0.m.b(resources.getString(o7.b.common_google_play_services_notification_ticker));
            mVar.f4272s.when = System.currentTimeMillis();
            mVar.f4261g = pendingIntent;
            mVar.f = e0.m.b(strD);
        }
        if (x7.b.d()) {
            if (!x7.b.d()) {
                throw new IllegalStateException();
            }
            synchronized (f11037c) {
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String string = context.getResources().getString(o7.b.common_google_play_services_notification_channel_name);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(lb.h.d(string));
            } else if (!string.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(string);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            mVar.f4270q = "com.google.android.gms.availability";
        }
        Notification notificationA = mVar.a();
        if (i == 1 || i == 2 || i == 3) {
            g.f11041a.set(false);
            i10 = 10436;
        } else {
            i10 = 39789;
        }
        notificationManager.notify(i10, notificationA);
    }

    public final void g(Activity activity, s7.f fVar, int i, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogD = d(activity, i, new t7.o(super.a(i, activity, "d"), fVar, 1), onCancelListener);
        if (alertDialogD == null) {
            return;
        }
        e(activity, alertDialogD, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
