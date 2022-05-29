package com.tcs.ins.assign.api;

import static com.tcs.ins.support.Constant.REQUEST_PARAM_MAPPING;
import static com.tcs.ins.support.Constant.REQUEST_PARAM_PAGE_NUMBER;
import static com.tcs.ins.support.Constant.REQUEST_PARAM_PAGE_SIZE;
import static com.tcs.ins.support.Constant.REQUEST_PARAM_SORT_BY;
import static com.tcs.ins.support.Constant.REQUEST_PARAM_SORT_DIRECTION;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tcs.ins.assign.service.PMSAssignService;
import com.tcs.ins.assign.service.model.AssignResourceModel;

@RestController
@RequestMapping(REQUEST_PARAM_MAPPING)
class PMSProjectDetailApi {

	private final PMSAssignService pMSAssignService;

	public PMSProjectDetailApi(PMSAssignService pMSAssignService) {
		this.pMSAssignService = pMSAssignService;
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<AssignResourceModel> getProject(@PathVariable Long id) {
		return ResponseEntity.ok(pMSAssignService.getAssignProject(id));
	}

	@GetMapping(path = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Page<AssignResourceModel>> searchProject(
			@RequestParam(name = REQUEST_PARAM_PAGE_NUMBER, required = true) Integer pageNumber,
			@RequestParam(name = REQUEST_PARAM_PAGE_SIZE, required = true) Integer pageSize,
			@RequestParam(name = REQUEST_PARAM_SORT_BY, required = false) String sortBy,
			@RequestParam(name = REQUEST_PARAM_SORT_DIRECTION, required = false) String sortDirection,
			@RequestParam Map<String, String> requestParam) {
		PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
		Page<AssignResourceModel> page = pMSAssignService.searchAssignProject(pageRequest);
		return ResponseEntity.ok(page);
	}

	@PostMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<AssignResourceModel> createProject(@PathVariable Long id, @RequestBody AssignResourceModel projectDetailModel, UriComponentsBuilder ucb) {
		projectDetailModel.setId(id);
		AssignResourceModel create = pMSAssignService.createAssignProject(projectDetailModel);
		return ResponseEntity.created(ucb
									  .path(REQUEST_PARAM_MAPPING + "/{id}")
									  .buildAndExpand(create.getId())
									  .toUri())
							  .body(create);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<AssignResourceModel> updateProject(@PathVariable Long id, @RequestBody AssignResourceModel projectDetailModel) {
		projectDetailModel.setId(id);
		AssignResourceModel update = pMSAssignService.updateAssignProject(projectDetailModel);
		return ResponseEntity.ok(update);
	}

	@DeleteMapping(path = "/{id}")
	ResponseEntity<Void> deleteProject(@PathVariable Long id) {
		pMSAssignService.deleteAssignProject(id);
		return ResponseEntity.ok(null);
	}
}
