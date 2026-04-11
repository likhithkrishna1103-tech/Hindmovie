package l4;

import android.content.Intent;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.ParcelImpl;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends MediaSession.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f7757a;

    public t(u uVar) {
        this.f7757a = uVar;
    }

    public static void b(w wVar) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            return;
        }
        MediaSession mediaSession = wVar.f7765a;
        String str = null;
        if (i >= 24) {
            try {
                str = (String) mediaSession.getClass().getMethod("getCallingPackage", null).invoke(mediaSession, null);
            } catch (Exception e9) {
                Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e9);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = "android.media.session.MediaController";
        }
        wVar.d(new e0(-1, -1, str));
    }

    public final w a() {
        w wVar;
        synchronized (this.f7757a.f7758a) {
            wVar = (w) this.f7757a.f7761d.get();
        }
        if (wVar == null || this.f7757a != wVar.b()) {
            return null;
        }
        return wVar;
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        n5.d dVar;
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        c0.K(bundle);
        b(wVarA);
        try {
            if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                if (resultReceiver != null) {
                    Bundle bundle2 = new Bundle();
                    b0 b0Var = wVarA.f7767c;
                    i iVarA = b0Var.a();
                    bundle2.putBinder("android.support.v4.media.session.EXTRA_BINDER", iVarA == null ? null : iVarA.asBinder());
                    synchronized (b0Var.f7700v) {
                        dVar = b0Var.f7703y;
                    }
                    if (dVar != null) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putParcelable("a", new ParcelImpl(dVar));
                        bundle2.putParcelable("android.support.v4.media.session.SESSION_TOKEN2", bundle3);
                    }
                    resultReceiver.send(0, bundle2);
                }
            } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                if (bundle != null) {
                    this.f7757a.b((o) w8.e.f(bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), o.CREATOR));
                }
            } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                if (bundle != null) {
                    this.f7757a.c((o) w8.e.f(bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), o.CREATOR), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                }
            } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                if (bundle != null) {
                    this.f7757a.q((o) w8.e.f(bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), o.CREATOR));
                }
            } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                List list = wVarA.f7771h;
                if (list != null && bundle != null) {
                    int i = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                    z zVar = (i < 0 || i >= list.size()) ? null : (z) list.get(i);
                    if (zVar != null) {
                        this.f7757a.q(zVar.f7776v);
                    }
                }
            } else {
                this.f7757a.d(str, bundle, resultReceiver);
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
        }
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onCustomAction(String str, Bundle bundle) {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        c0.K(bundle);
        b(wVarA);
        try {
            boolean zEquals = str.equals("android.support.v4.media.session.action.PLAY_FROM_URI");
            u uVar = this.f7757a;
            if (zEquals) {
                if (bundle != null) {
                    Uri uri = (Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                    Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                    c0.K(bundle2);
                    uVar.l(uri, bundle2);
                }
            } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                uVar.m();
            } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                if (bundle != null) {
                    String string = bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                    Bundle bundle3 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                    c0.K(bundle3);
                    uVar.n(string, bundle3);
                }
            } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                if (bundle != null) {
                    String string2 = bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                    Bundle bundle4 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                    c0.K(bundle4);
                    uVar.o(string2, bundle4);
                }
            } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                if (bundle != null) {
                    Uri uri2 = (Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI");
                    Bundle bundle5 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                    c0.K(bundle5);
                    uVar.p(uri2, bundle5);
                }
            } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                if (bundle != null) {
                    bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED");
                }
            } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                if (bundle != null) {
                    uVar.w(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                }
            } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                if (bundle != null) {
                    uVar.x(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                }
            } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                if (bundle != null) {
                    l0 l0Var = (l0) w8.e.f(bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING"), l0.CREATOR);
                    c0.K(bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                    uVar.v(l0Var);
                }
            } else if (!str.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                uVar.e(str, bundle);
            } else if (bundle != null) {
                uVar.t(bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f));
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
        }
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onFastForward() {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        b(wVarA);
        this.f7757a.f();
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final boolean onMediaButtonEvent(Intent intent) {
        w wVarA = a();
        if (wVarA == null) {
            return false;
        }
        b(wVarA);
        boolean zG = this.f7757a.g(intent);
        wVarA.d(null);
        return zG || super.onMediaButtonEvent(intent);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPause() {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        b(wVarA);
        this.f7757a.h();
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlay() {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        b(wVarA);
        this.f7757a.i();
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlayFromMediaId(String str, Bundle bundle) {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        c0.K(bundle);
        b(wVarA);
        this.f7757a.j(str, bundle);
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlayFromSearch(String str, Bundle bundle) {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        c0.K(bundle);
        b(wVarA);
        this.f7757a.k(str, bundle);
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlayFromUri(Uri uri, Bundle bundle) {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        c0.K(bundle);
        b(wVarA);
        this.f7757a.l(uri, bundle);
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepare() {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        b(wVarA);
        this.f7757a.m();
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepareFromMediaId(String str, Bundle bundle) {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        c0.K(bundle);
        b(wVarA);
        this.f7757a.n(str, bundle);
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepareFromSearch(String str, Bundle bundle) {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        c0.K(bundle);
        b(wVarA);
        this.f7757a.o(str, bundle);
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepareFromUri(Uri uri, Bundle bundle) {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        c0.K(bundle);
        b(wVarA);
        this.f7757a.p(uri, bundle);
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onRewind() {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        b(wVarA);
        this.f7757a.r();
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSeekTo(long j4) {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        b(wVarA);
        this.f7757a.s(j4);
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSetPlaybackSpeed(float f) {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        b(wVarA);
        this.f7757a.t(f);
        wVarA.d(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    @Override // android.media.session.MediaSession.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onSetRating(android.media.Rating r7) {
        /*
            r6 = this;
            l4.w r0 = r6.a()
            if (r0 != 0) goto L7
            return
        L7:
            b(r0)
            r1 = 0
            if (r7 == 0) goto L1d
            int r2 = r7.getRatingStyle()
            boolean r3 = r7.isRated()
            if (r3 == 0) goto L4e
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            switch(r2) {
                case 1: goto L40;
                case 2: goto L31;
                case 3: goto L28;
                case 4: goto L28;
                case 5: goto L28;
                case 6: goto L1f;
                default: goto L1d;
            }
        L1d:
            r2 = r1
            goto L60
        L1f:
            float r2 = r7.getPercentRating()
            l4.l0 r2 = l4.l0.c(r2)
            goto L5b
        L28:
            float r3 = r7.getStarRating()
            l4.l0 r2 = l4.l0.d(r2, r3)
            goto L5b
        L31:
            boolean r2 = r7.isThumbUp()
            l4.l0 r5 = new l4.l0
            if (r2 == 0) goto L3a
            r3 = r4
        L3a:
            r2 = 2
            r5.<init>(r2, r3)
        L3e:
            r2 = r5
            goto L5b
        L40:
            boolean r2 = r7.hasHeart()
            l4.l0 r5 = new l4.l0
            if (r2 == 0) goto L49
            r3 = r4
        L49:
            r2 = 1
            r5.<init>(r2, r3)
            goto L3e
        L4e:
            switch(r2) {
                case 1: goto L53;
                case 2: goto L53;
                case 3: goto L53;
                case 4: goto L53;
                case 5: goto L53;
                case 6: goto L53;
                default: goto L51;
            }
        L51:
            r2 = r1
            goto L5b
        L53:
            l4.l0 r3 = new l4.l0
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r3.<init>(r2, r4)
            r2 = r3
        L5b:
            r2.getClass()
            r2.f7740x = r7
        L60:
            l4.u r7 = r6.f7757a
            r7.u(r2)
            r0.d(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.t.onSetRating(android.media.Rating):void");
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSkipToNext() {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        b(wVarA);
        this.f7757a.y();
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSkipToPrevious() {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        b(wVarA);
        this.f7757a.z();
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSkipToQueueItem(long j4) {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        b(wVarA);
        this.f7757a.A(j4);
        wVarA.d(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onStop() {
        w wVarA = a();
        if (wVarA == null) {
            return;
        }
        b(wVarA);
        this.f7757a.B();
        wVarA.d(null);
    }
}
