package com.stripe.model;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.net.APIResource;
import com.stripe.net.RequestOptions;

import java.util.Map;

public class CustomerCardCollection extends StripeCollection<Card> {
	public CustomerCardCollection list(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, null);
	}

	public CustomerCardCollection list(Map<String, Object> params,
			RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		String url = String.format("%s%s", Stripe.getApiBase(), this.getURL());
		return APIResource.requestCollection(url, params, CustomerCardCollection.class, options);
	}

	@Deprecated
	public CustomerCardCollection all(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		return list(params, null);
	}

	@Deprecated
	public CustomerCardCollection all(Map<String, Object> params,
			String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return list(params, RequestOptions.builder().setApiKey(apiKey).build());
	}

	@Deprecated
	public CustomerCardCollection all(Map<String, Object> params,
			RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		return list(params, options);
	}

	public Card retrieve(String id)
		throws AuthenticationException, InvalidRequestException,
		APIConnectionException, CardException, APIException {
	return retrieve(id, (RequestOptions) null);
	}

	@Deprecated
	public Card retrieve(String id, String apiKey) throws AuthenticationException,
		InvalidRequestException, APIConnectionException, CardException,
		APIException {
	return retrieve(id, RequestOptions.builder().setApiKey(apiKey).build());
	}
	public Card retrieve(String id, RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		String url = String.format("%s%s/%s", Stripe.getApiBase(), this.getURL(), id);
		return APIResource.request(APIResource.RequestMethod.GET, url, null, Card.class, options);
	}

	public Card create(Map<String, Object> params)
		throws AuthenticationException, InvalidRequestException,
		APIConnectionException, CardException, APIException {
	return create(params, (RequestOptions) null);
	}

	@Deprecated
	public Card create(Map<String, Object> params,
		String apiKey) throws AuthenticationException,
		InvalidRequestException, APIConnectionException, CardException,
		APIException {
		return create(params, RequestOptions.builder().setApiKey(apiKey).build());
	}
	public Card create(Map<String, Object> params,
			RequestOptions options) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, CardException,
			APIException {
		String url = String.format("%s%s", Stripe.getApiBase(), this.getURL());
		return APIResource.request(APIResource.RequestMethod.POST, url, params, Card.class, options);
	}
}
